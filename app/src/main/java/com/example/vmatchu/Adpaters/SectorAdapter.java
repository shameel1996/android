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
import com.example.vmatchu.SharedPrefs.SaveInSharedPreference;
import com.example.vmatchu.R;

import java.util.ArrayList;

public class SectorAdapter extends RecyclerView.Adapter<SectorAdapter.ViewHolderSector>{

    private ArrayList<CityAreaSubareaSectorDetailsResponse> sector;
    private Context context;
    private LayoutInflater mInflater;
    private OnItemClick itemClick;
    SaveInSharedPreference saveInSharedPreference;
    Dialog dialog;
    TextView sectortxt;
    DBhelper dBhelper;

    public SectorAdapter(ArrayList<CityAreaSubareaSectorDetailsResponse> sector, Context context, Dialog dialog, TextView sectortxt) {
        this.sector = sector;
        this.context=context;
        this.mInflater = LayoutInflater.from(context);
        saveInSharedPreference = new SaveInSharedPreference(context);
        this.dialog = dialog;
        this.sectortxt = sectortxt;
        dBhelper = new DBhelper(context);
    }


    @NonNull
    @Override
    public ViewHolderSector onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= mInflater.inflate(R.layout.sector,null);
        return new ViewHolderSector(view);

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
    public void onBindViewHolder(@NonNull ViewHolderSector viewHolderSector, final int i) {
//        ViewHolderCityviewHolderCity=(ViewHolderCity)viewHolder;
        ViewHolderSector viewHolder1 =(ViewHolderSector)viewHolderSector;
        String sectorName=sector.get(i).getName();
        viewHolder1.sector_ed.setText(sectorName);

        viewHolder1.relative_row_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String term_id = sector.get(i).getTermId();
                saveInSharedPreference.saveSectorId(term_id);
                sectortxt.setText(dBhelper.getSectorById(term_id));
                dialog.dismiss();
            }
        });

    }


    @Override
    public int getItemCount() {
        if(sector!=null){
            return sector.size();
        }
        else {
            return 0;
        }
    }



    public class ViewHolderSector extends RecyclerView.ViewHolder implements View.OnClickListener {

        RelativeLayout relative_row_city;
        TextView sector_ed;




        public ViewHolderSector(@NonNull View itemView) {
            super(itemView);

            relative_row_city = itemView.findViewById(R.id.relative_row_sector);
            sector_ed=itemView.findViewById(R.id.sector_ed);
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
