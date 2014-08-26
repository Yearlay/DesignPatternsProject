package com.amt.designpatterns.K_Adapter;

import java.util.ArrayList;

import com.amt.designpatterns.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class GridViewAdapter extends BaseAdapter {
    
protected ImageLoader imageLoader = ImageLoader.getInstance();
    
    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    DisplayImageOptions options;
    
    protected ArrayList<ImageData> imageDataList = new ArrayList<ImageData>();
    
    public GridViewAdapter() {
        options = new DisplayImageOptions.Builder()
        .showImageOnLoading(R.drawable.ic_stub)
        .showImageForEmptyUri(R.drawable.ic_empty)
        .showImageOnFail(R.drawable.ic_error)
        .cacheInMemory(true)
        .cacheOnDisk(true)
        .considerExifParams(true)
        .bitmapConfig(Bitmap.Config.RGB_565)
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
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_image, parent, false);
            holder = new ViewHolder();
            assert view != null;
            holder.imageView = (ImageView) view.findViewById(R.id.image);
            holder.progressBar = (ProgressBar) view.findViewById(R.id.progress);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        imageLoader.displayImage(imageDataList.get(position).data, holder.imageView, options, new SimpleImageLoadingListener() {
                                     @Override
                                     public void onLoadingStarted(String imageUri, View view) {
                                         holder.progressBar.setProgress(0);
                                         holder.progressBar.setVisibility(View.VISIBLE);
                                     }

                                     @Override
                                     public void onLoadingFailed(String imageUri, View view,
                                             FailReason failReason) {
                                         holder.progressBar.setVisibility(View.GONE);
                                     }

                                     @Override
                                     public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                                         holder.progressBar.setVisibility(View.GONE);
                                     }
                                 }, new ImageLoadingProgressListener() {
                                     @Override
                                     public void onProgressUpdate(String imageUri, View view, int current,
                                             int total) {
                                         holder.progressBar.setProgress(Math.round(100.0f * current / total));
                                     }
                                 }
        );

        return view;
    }
    
    static class ViewHolder {
        ImageView imageView;
        ProgressBar progressBar;
    }

}
