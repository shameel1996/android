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

import com.example.vmatchu.DBhelper.DBhelper;
import com.example.vmatchu.Interfaces.OnItemClick;
import com.example.vmatchu.Pojo.CityAreaSubareaSectorDetailsResponse;
import com.example.vmatchu.R;
import com.example.vmatchu.SharedPrefs.SaveInSharedPreference;

import java.util.ArrayList;

public class SubAreaAdapter extends RecyclerView.Adapter<SubAreaAdapter.ViewHolderSubArea>{

    private ArrayList<CityAreaSubareaSectorDetailsResponse> subarea;
    private Context context;
    private LayoutInflater mInflater;
    private OnItemClick itemClick;
    SaveInSharedPreference saveInSharedPreference;
    Dialog dialog;
    TextView subareatxt;
    DBhelper dBhelper;

    public SubAreaAdapter(ArrayList<CityAreaSubareaSectorDetailsResponse> subarea, Context context, Dialog dialog, TextView subareatxt) {
        this.subarea = subarea;
        this.context=context;
        this.mInflater = LayoutInflater.from(context);
        saveInSharedPreference = new SaveInSharedPreference(context);
        this.dialog = dialog;
        this.subareatxt = subareatxt;
        dBhelper = new DBhelper(context);
    }


    @NonNull
    @Override
    public ViewHolderSubArea onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= mInflater.inflate(R.layout.subarea,null);
        return new ViewHolderSubArea(view);

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
    public void onBindViewHolder(@NonNull ViewHolderSubArea viewHolderSubArea, final int i) {
//        ViewHolderCityviewHolderCity=(ViewHolderCity)viewHolder;
        ViewHolderSubArea viewHolder1 =(ViewHolderSubArea)viewHolderSubArea;
        String subAreaName=subarea.get(i).getName();
        viewHolder1.subbarea_ed.setText(subAreaName);

        viewHolder1.relative_row_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String term_id = subarea.get(i).getTermId();
                saveInSharedPreference.saveSubAreaId(term_id);
                subareatxt.setText(dBhelper.getSubAreaById(term_id));
                dialog.dismiss();
            }
        });

    }


    @Override
    public int getItemCount() {
        if(subarea!=null){
            return subarea.size();
        }
        else {
            return 0;
        }
    }



    public class ViewHolderSubArea extends RecyclerView.ViewHolder implements View.OnClickListener {

        RelativeLayout relative_row_city;
        TextView subbarea_ed;




        public ViewHolderSubArea(@NonNull View itemView) {
            super(itemView);

            relative_row_city = itemView.findViewById(R.id.relative_row_subarea);
            subbarea_ed=itemView.findViewById(R.id.subarea_ed);
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
