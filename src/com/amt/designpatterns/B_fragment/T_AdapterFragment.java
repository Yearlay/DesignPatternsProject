package com.amt.designpatterns.B_fragment;

import java.util.ArrayList;

import com.amt.designpatterns.R;
import com.amt.designpatterns.A_activity.ImagePagerActivity;
import com.amt.designpatterns.K_Adapter.GridViewAdapter;
import com.amt.designpatterns.K_Adapter.ImageData;
import com.amt.designpatterns.K_Adapter.ListViewAdapter;
import com.amt.designpatterns.Y_data.MediaImageDataArray;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

public class T_AdapterFragment extends Z_BaseFragment implements OnItemClickListener {
    
    private static final String URI_HEAD = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()
            + "/";
    
    protected ArrayList<ImageData> imageDataList = new ArrayList<ImageData>();
    
    private ListView mListView;
    private GridView mGridView;
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.image_list, container, false);
        
        ((TextView) rootView.findViewById(R.id.description)).setText("Adapter: Read the picture of the phone.");
        
        mListView =  (ListView) rootView.findViewById(R.id.listview);
        mGridView = (GridView) rootView.findViewById(R.id.gridview);
        mListView.setOnItemClickListener(this);
        mGridView.setOnItemClickListener(this);
        mGridView.setVisibility(View.GONE);
        
        ((Button) rootView.findViewById(R.id.show_listview)).setOnClickListener(this);
        ((Button) rootView.findViewById(R.id.show_gridview)).setOnClickListener(this);
        
        new UpdateTextTask().execute();
        
        return rootView;
    }

    @Override
    protected void refreshView() {
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void clearData() {}

    @Override
    protected void clickWidget(View view) {
        switch (view.getId()) {
            case R.id.show_listview:
                mListView.setVisibility(View.VISIBLE);
                mGridView.setVisibility(View.GONE);
                break;
            case R.id.show_gridview:
                mListView.setVisibility(View.GONE);
                mGridView.setVisibility(View.VISIBLE);
                break;
                
            default:
                break;
        }
    }

    public ArrayList<ImageData> initImageDateArrayList() {
        ContentResolver resolver = this.getActivity().getContentResolver();
        String[] projection = {MediaStore.Images.Media._ID, 
                MediaStore.Images.Media.DATA};
        ArrayList<ImageData> imageDataList = new ArrayList<ImageData>();
        Cursor cursor = null;
        try {
            cursor = resolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection , null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                Log.e("Yearlay", "--------cursor size : " + cursor.getCount());
                do {
                    ImageData imageData = new ImageData();
                    imageData.id = cursor.getLong(0);
                    imageData.data = "file://" + cursor.getString(1);
                    imageData.uri = URI_HEAD + imageData.id;
                    imageDataList.add(imageData);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return imageDataList;
    }
    
    class UpdateTextTask extends AsyncTask<Void , Void, Void> {

        @Override
        protected void onPostExecute(Void result) {
            ListViewAdapter listViewAdapter = new ListViewAdapter();
            listViewAdapter.setImageDataList(imageDataList);
            listViewAdapter.getImageLoader().init(ImageLoaderConfiguration.createDefault(T_AdapterFragment.this.getActivity()));
            mListView.setAdapter(listViewAdapter);
            
            GridViewAdapter gridViewAdapter = new GridViewAdapter();
            gridViewAdapter.setImageDataList(imageDataList);
            gridViewAdapter.getImageLoader().init(ImageLoaderConfiguration.createDefault(T_AdapterFragment.this.getActivity()));
            mGridView.setAdapter(gridViewAdapter);
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            imageDataList = initImageDateArrayList();
            MediaImageDataArray.instance().setImageDataList(imageDataList);
            return null;
        }
        
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View itemView, int position, long arg3) {
        Intent intent = new Intent(this.getActivity(), ImagePagerActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);

    }
}
