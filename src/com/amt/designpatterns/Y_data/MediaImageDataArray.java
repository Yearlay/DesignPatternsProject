package com.amt.designpatterns.Y_data;

import java.util.ArrayList;

import com.amt.designpatterns.K_Adapter.ImageData;


public class MediaImageDataArray {
    static MediaImageDataArray mMediaImageDataArray;
    
    protected ArrayList<ImageData> imageDataList = new ArrayList<ImageData>();
    
    public ArrayList<ImageData> getImageDataList() {
        return imageDataList;
    }

    public void setImageDataList(ArrayList<ImageData> imageDataList) {
        this.imageDataList = imageDataList;
    }

    public static MediaImageDataArray instance() {
        if (mMediaImageDataArray == null) {
            mMediaImageDataArray = new MediaImageDataArray();
        }
        return mMediaImageDataArray;
    }
    
}
