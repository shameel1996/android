package com.example.vmatchu.Adpaters;

import android.app.AlertDialog;
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
import com.example.vmatchu.EnterPropertyDetailActivity;
import com.example.vmatchu.Interfaces.OnItemClick;
import com.example.vmatchu.Pojo.CityAreaSubareaSectorDetailsResponse;
import com.example.vmatchu.R;
import com.example.vmatchu.SharedPrefs.SaveInSharedPreference;

import java.util.ArrayList;

public class cityAdapter extends RecyclerView.Adapter<cityAdapter.ViewHolderCity>{

    private ArrayList<CityAreaSubareaSectorDetailsResponse> city;
    private Context context;
    private LayoutInflater mInflater;
    private OnItemClick itemClick;
    SaveInSharedPreference saveInSharedPreference;
    Dialog dialog;
    TextView citytxt;
    DBhelper dBhelper;

    public cityAdapter(ArrayList<CityAreaSubareaSectorDetailsResponse> city, Context context, Dialog dialog, TextView citytxt) {
        this.city = city;
        this.context=context;
        this.mInflater = LayoutInflater.from(context);
        saveInSharedPreference = new SaveInSharedPreference(context);
        this.dialog = dialog;
        this.citytxt = citytxt;
        dBhelper = new DBhelper(context);
    }


    @NonNull
    @Override
    public ViewHolderCity onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= mInflater.inflate(R.layout.city,null);
        return new ViewHolderCity(view);

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
    public void onBindViewHolder(@NonNull ViewHolderCity viewHolderCity, final int i) {
//        ViewHolderCityviewHolderCity=(ViewHolderCity)viewHolder;
        ViewHolderCity viewHolder1 =(ViewHolderCity)viewHolderCity;
        String cityName=city.get(i).getName();
        viewHolder1.city_ed.setText(cityName);

        viewHolder1.relative_row_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String term_id = city.get(i).getTermId();
                saveInSharedPreference.saveCityId(term_id);
                citytxt.setText(dBhelper.getCityById(term_id));
                dialog.dismiss();
            }
        });

    }


    @Override
    public int getItemCount() {
        if(city!=null){
            return city.size();
        }
        else {
            return 0;
        }
    }



    public class ViewHolderCity extends RecyclerView.ViewHolder implements View.OnClickListener {

        RelativeLayout relative_row_city;
        TextView city_ed;




        public ViewHolderCity(@NonNull View itemView) {
            super(itemView);

            relative_row_city = itemView.findViewById(R.id.relative_row_city);
            city_ed=itemView.findViewById(R.id.City_ed);
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
