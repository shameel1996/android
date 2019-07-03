package com.example.vmatchu.Adpaters;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.vmatchu.R;

import java.util.ArrayList;

public class GalleryAdapter extends BaseAdapter {

    private Context ctx;
    private int pos;
    private LayoutInflater inflater;
    private ImageView ivGallery;
    private ImageButton imageButton;
    private RelativeLayout relativeLayout;
    private ArrayList<Bitmap> mArrayUri;
    public GalleryAdapter(Context ctx, ArrayList<Bitmap> mArrayUri) {

        this.ctx = ctx;
        this.mArrayUri = mArrayUri;
    }

    @Override
    public int getCount() {
        return mArrayUri.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayUri.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {


        inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View itemView = inflater.inflate(R.layout.gv_items, parent, false);


        ivGallery = (ImageView) itemView.findViewById(R.id.ivGallery);


        ivGallery.setImageBitmap(mArrayUri.get(position));



        return itemView;
    }


}
