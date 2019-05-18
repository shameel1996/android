package com.example.vmatchu.Adpaters;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
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
import com.example.vmatchu.SharedPrefs.SaveInSharedPreference;
import com.example.vmatchu.R;


import java.util.ArrayList;

public class AreaTypeAdapter extends RecyclerView.Adapter<AreaTypeAdapter.ViewHolderAreaType>{

    private ArrayList<CityAreaSubareaSectorDetailsResponse> areaType;
    private Context context;
    private LayoutInflater mInflater;
    private OnItemClick itemClick;
    SaveInSharedPreference saveInSharedPreference;
    Dialog dialog;
    TextView areaTypeText;
    DBhelper dBhelper;

    public AreaTypeAdapter(ArrayList<CityAreaSubareaSectorDetailsResponse> areaType, Context context, Dialog dialog, TextView areaTypeText) {
        this.areaType = areaType;
        this.context=context;
        this.mInflater = LayoutInflater.from(context);
        saveInSharedPreference = new SaveInSharedPreference(context);
        this.dialog = dialog;
        this.areaTypeText = areaTypeText;
        dBhelper = new DBhelper(context);
    }


    @NonNull
    @Override
    public ViewHolderAreaType onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = mInflater.inflate(R.layout.area_type,null);
        return new ViewHolderAreaType(view);

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
    public void onBindViewHolder(@NonNull ViewHolderAreaType viewHolderAreaType, final int i) {
//        ViewHolderCityviewHolderCity=(ViewHolderCity)viewHolder;
        ViewHolderAreaType viewHolder1 =(ViewHolderAreaType)viewHolderAreaType;
        String areaTypeName = areaType.get(i).getName();
        viewHolder1.areatype_ed.setText(areaTypeName);

        viewHolder1.relative_row_area_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String term_id = areaType.get(i).getTermId();
                saveInSharedPreference.saveAreaTypeId(term_id);
                areaTypeText.setText(dBhelper.getAreaTypeById(term_id));
                dialog.dismiss();
            }
        });

    }


    @Override
    public int getItemCount() {
        if(areaType!=null){
            return areaType.size();
        }
        else {
            return 0;
        }
    }



    public class ViewHolderAreaType extends RecyclerView.ViewHolder implements View.OnClickListener {

        RelativeLayout relative_row_area_type;
        TextView areatype_ed;




        public ViewHolderAreaType(@NonNull View itemView) {
            super(itemView);

            relative_row_area_type = itemView.findViewById(R.id.relative_row_area_type);
            areatype_ed=itemView.findViewById(R.id.area_type_ed);
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
