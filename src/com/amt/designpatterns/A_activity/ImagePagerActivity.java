/*******************************************************************************
 * Copyright 2011-2013 Sergey Tarasevich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.amt.designpatterns.A_activity;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.amt.designpatterns.R;
import com.amt.designpatterns.K_Adapter.ImageData;
import com.amt.designpatterns.Y_data.MediaImageDataArray;

/**
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public class ImagePagerActivity extends Activity {

    protected ImageLoader imageLoader = ImageLoader.getInstance();
    
	private static final String STATE_POSITION = "STATE_POSITION";
	
	protected ArrayList<ImageData> imageDataList;

	DisplayImageOptions options;

	ViewPager pager;

    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ac_image_pager);

		Bundle bundle = getIntent().getExtras();
		assert bundle != null;
		imageDataList = MediaImageDataArray.instance().getImageDataList();
		int pagerPosition = bundle.getInt("position", 0);

		if (savedInstanceState != null) {
			pagerPosition = savedInstanceState.getInt(STATE_POSITION);
		}
		
		imageLoader.init(ImageLoaderConfiguration.createDefault(getApplicationContext()));

		options = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.drawable.ic_empty)
                .showImageOnFail(R.drawable.ic_error)
                .resetViewBeforeLoading(true)
                .cacheOnDisk(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .considerExifParams(true)
                .displayer(new FadeInBitmapDisplayer(300))
                .build();

		pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(new ImagePagerAdapter(imageDataList));
		pager.setCurrentItem(pagerPosition);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		outState.putInt(STATE_POSITION, pager.getCurrentItem());
	}

	private class ImagePagerAdapter extends PagerAdapter {

		private ArrayList<ImageData> imageArrayList;
		private LayoutInflater inflater;

		ImagePagerAdapter(ArrayList<ImageData> imageArrayList) {
			this.imageArrayList = imageArrayList;
			inflater = getLayoutInflater();
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

		@Override
		public int getCount() {
			return imageArrayList.size();
		}

		@Override
		public Object instantiateItem(ViewGroup view, int position) {
			View imageLayout = inflater.inflate(R.layout.item_pager_image, view, false);
			assert imageLayout != null;
			ImageView imageView = (ImageView) imageLayout.findViewById(R.id.image);
			final ProgressBar spinner = (ProgressBar) imageLayout.findViewById(R.id.loading);
			SimpleImageLoadingListener simpleImageLoadingListener = new MySimpleImageLoadingListener(spinner);
            imageLoader.displayImage(imageDataList.get(position).data, imageView, options, simpleImageLoadingListener);

			view.addView(imageLayout, 0);
			return imageLayout;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view.equals(object);
		}

		@Override
		public void restoreState(Parcelable state, ClassLoader loader) {
		}

		@Override
		public Parcelable saveState() {
			return null;
		}
	}
	
	private class MySimpleImageLoadingListener extends SimpleImageLoadingListener {
	    private ProgressBar spinner;
	    
	    public MySimpleImageLoadingListener(ProgressBar spinner) {
	        this.spinner = spinner;
	    }
	    
	    @Override
        public void onLoadingStarted(String imageUri, View view) {
            spinner.setVisibility(View.VISIBLE);
        }

        @Override
        public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
            String message = null;
            switch (failReason.getType()) {
                case IO_ERROR:
                    message = "Input/Output error";
                    break;
                case DECODING_ERROR:
                    message = "Image can't be decoded";
                    break;
                case NETWORK_DENIED:
                    message = "Downloads are denied";
                    break;
                case OUT_OF_MEMORY:
                    message = "Out Of Memory error";
                    break;
                case UNKNOWN:
                    message = "Unknown error";
                    break;
            }
            Toast.makeText(ImagePagerActivity.this, message, Toast.LENGTH_SHORT).show();

            spinner.setVisibility(View.GONE);
        }

        @Override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
            spinner.setVisibility(View.GONE);
        }
	}
}