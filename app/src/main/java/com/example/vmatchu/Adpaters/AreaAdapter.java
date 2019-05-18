package com.example.vmatchu.Adpaters;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.vmatchu.R;

import com.example.vmatchu.DBhelper.DBhelper;
import com.example.vmatchu.Interfaces.OnItemClick;
import com.example.vmatchu.Pojo.CityAreaSubareaSectorDetailsResponse;
import com.example.vmatchu.R;
import com.example.vmatchu.SharedPrefs.SaveInSharedPreference;

import java.util.ArrayList;

public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.ViewHolderArea>{

    private ArrayList<CityAreaSubareaSectorDetailsResponse> area;
    private Context context;
    private LayoutInflater mInflater;
    private OnItemClick itemClick;
    SaveInSharedPreference saveInSharedPreference;
    Dialog dialog;
    TextView areatxt;
    DBhelper dBhelper;

    public AreaAdapter(ArrayList<CityAreaSubareaSectorDetailsResponse> area, Context context, Dialog dialog, TextView areatxt) {
        this.area = area;
        this.context=context;
        this.mInflater = LayoutInflater.from(context);
        saveInSharedPreference = new SaveInSharedPreference(context);
        this.dialog = dialog;
        this.areatxt = areatxt;
        dBhelper = new DBhelper(context);
    }


    @NonNull
    @Override
    public ViewHolderArea onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = mInflater.inflate(R.layout.area,null);
        return new ViewHolderArea(view);

    }
//
//    public OnItemClick getItemClick() {
//        return itemClick;
//    }
//
//    public void setItemClick(OnItemClick itemClick) {
//        this.itemClick = itemClick;
//    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderArea viewHolderArea, final int i) {
//        ViewHolderCityviewHolderCity=(ViewHolderCity)viewHolder;
        ViewHolderArea viewHolder1 =(ViewHolderArea)viewHolderArea;
        String areaName=area.get(i).getName();
        viewHolder1.area_ed.setText(areaName);

        viewHolder1.relative_row_area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String term_id = area.get(i).getTermId();
                saveInSharedPreference.saveAreaId(term_id);
                areatxt.setText(dBhelper.getAreaById(term_id));
                dialog.dismiss();
            }
        });

    }


    @Override
    public int getItemCount() {
        if(area!=null){
            return area.size();
        }
        else {
            return 0;
        }
    }



    public class ViewHolderArea extends RecyclerView.ViewHolder implements View.OnClickListener {


        RelativeLayout relative_row_area;

        TextView area_ed;




        public ViewHolderArea(@NonNull View itemView) {
            super(itemView);


            relative_row_area = itemView.findViewById(R.id.relative_row_area);
            area_ed=itemView.findViewById(R.id.area_ed);

//
//            itemView.setClickable(true);
//            itemView.setOnClickListener((View.OnClickListener) this);

        }

        @Override
        public void onClick(View view) {
//            if (itemClick != null) {
//                itemClick.onItemClicked(getPosition());
//            }
        }
    }

}
