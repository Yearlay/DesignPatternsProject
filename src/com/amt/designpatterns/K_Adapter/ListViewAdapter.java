package com.amt.designpatterns.K_Adapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amt.designpatterns.R;

public class ListViewAdapter extends BaseAdapter {
    
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    
    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    DisplayImageOptions options;
    
    protected ArrayList<ImageData> imageDataList = new ArrayList<ImageData>();
    
    private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();
    
    public ImageLoadingListener getAnimateFirstListener() {
        return animateFirstListener;
    }

    public ListViewAdapter() {
        options = new DisplayImageOptions.Builder()
        .showImageOnLoading(R.drawable.ic_stub)
        .showImageForEmptyUri(R.drawable.ic_empty)
        .showImageOnFail(R.drawable.ic_error)
        .cacheInMemory(true)
        .cacheOnDisk(true)
        .considerExifParams(true)
         .displayer(new RoundedBitmapDisplayer(15))
        .build();
    }

    public ArrayList<ImageData> getImageDataList() {
        return imageDataList;
    }

    public void setImageDataList(ArrayList<ImageData> imageDataList) {
        this.imageDataList = imageDataList;
    }

    @Override
    public int getCount() {
        return imageDataList.size();
    }

    @Override
    public ImageData getItem(int position) {
        return imageDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return imageDataList.get(position).id;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        final ViewHolder holder;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_image, parent, false);
            holder = new ViewHolder();
            holder.text = (TextView) view.findViewById(R.id.text);
            holder.image = (ImageView) view.findViewById(R.id.image);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.text.setText(imageDataList.get(position).data);

        imageLoader.displayImage(imageDataList.get(position).data, holder.image, options, animateFirstListener);

        return view;
    }
    
    private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener {

        static final List<String> displayedImages = Collections.synchronizedList(new LinkedList<String>());

        @Override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
            if (loadedImage != null) {
                ImageView imageView = (ImageView) view;
                boolean firstDisplay = !displayedImages.contains(imageUri);
                if (firstDisplay) {
                    FadeInBitmapDisplayer.animate(imageView, 500);
                    displayedImages.add(imageUri);
                }
            }
        }
    }
    
    private static class ViewHolder {
        TextView text;
        ImageView image;
    }

}
