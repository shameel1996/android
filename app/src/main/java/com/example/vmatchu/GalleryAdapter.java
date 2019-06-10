package com.example.vmatchu;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class GalleryAdapter extends BaseAdapter {

    private Context ctx;
    private int pos;
    private LayoutInflater inflater;
    private ImageView ivGallery;
    private ImageButton imageButton;
    ArrayList<Uri> mArrayUri;
    public GalleryAdapter(Context ctx, ArrayList<Uri> mArrayUri) {

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

        imageButton=(ImageButton) itemView.findViewById(R.id.delete_image);

        ivGallery.setImageURI(mArrayUri.get(position));

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mArrayUri.remove(getItem(position));


//                mArrayUri.get(position);
                ivGallery.setImageURI(null);
                //parent.removeView(convertView);
                itemView.setVisibility(View.GONE);

            }

        });


        return itemView;
    }


}
