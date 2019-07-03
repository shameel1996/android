package com.example.vmatchu.Adpaters;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vmatchu.DBhelper.DBhelper;
import com.example.vmatchu.Interfaces.OnItemClick;
import com.example.vmatchu.Pojo.CityAreaSubareaSectorDetailsResponse;
import com.example.vmatchu.Pojo.PropertyType;
import com.example.vmatchu.Pojo.PropertyTypeData;
import com.example.vmatchu.SharedPrefs.SaveInSharedPreference;
import com.example.vmatchu.R;

import java.util.ArrayList;

public class PropertyTypeAdapter  extends RecyclerView.Adapter<PropertyTypeAdapter.ViewHolderPropertyType>{

    private ArrayList<PropertyTypeData> propertyTypeData;
    private Context context;
    private LayoutInflater mInflater;
    private OnItemClick itemClick;
    SaveInSharedPreference saveInSharedPreference;
    Dialog dialog;
    TextView propertyTypeTxt;
    DBhelper dBhelper;

    public PropertyTypeAdapter(ArrayList<PropertyTypeData> propertyTypeData, Context context, Dialog dialog, TextView propertyTypeTxt) {
        this.propertyTypeData = propertyTypeData;
        this.context=context;
        this.mInflater = LayoutInflater.from(context);
        saveInSharedPreference = new SaveInSharedPreference(context);
        this.dialog = dialog;
        this.propertyTypeTxt = propertyTypeTxt;
        dBhelper = new DBhelper(context);
    }



    @NonNull
    @Override
    public ViewHolderPropertyType onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= mInflater.inflate(R.layout.property_type,null);
        return new ViewHolderPropertyType(view);

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
    public void onBindViewHolder(@NonNull ViewHolderPropertyType viewHolderPropertyType, final int i) {
//        ViewHolderCityviewHolderCity=(ViewHolderCity)viewHolder;
        ViewHolderPropertyType viewHolder1 =(ViewHolderPropertyType)viewHolderPropertyType;
        String propertyTypeString=propertyTypeData.get(i).getPropertyName();
        viewHolder1.property_type_ed.setText(propertyTypeString);

        viewHolder1.relative_row_property_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String term_id = propertyTypeData.get(i).getTermId();
                saveInSharedPreference.savePropertyTypeId(term_id);
                propertyTypeTxt.setText(dBhelper.getPropertyTypeById(term_id));
                dialog.dismiss();
            }
        });

    }



    @Override
    public int getItemCount() {
        if(propertyTypeData!=null){
            return propertyTypeData.size();
        }
        else {
            return 0;
        }
    }



    public class ViewHolderPropertyType extends RecyclerView.ViewHolder implements View.OnClickListener {

        RelativeLayout relative_row_property_type;
        TextView property_type_ed;




        public ViewHolderPropertyType(@NonNull View itemView) {
            super(itemView);

            relative_row_property_type = itemView.findViewById(R.id.relative_row_property_type);
            property_type_ed=itemView.findViewById(R.id.property_type_ed);
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