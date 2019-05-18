package com.example.vmatchu.Adpaters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.vmatchu.MatchPropertyActivity;
import com.example.vmatchu.Pojo.MyPropertyForDB;
import com.example.vmatchu.R;

import java.util.ArrayList;

public class MatchPropertyAdapter extends RecyclerView.Adapter{
    private ArrayList<MyPropertyForDB> matchPropertyLsit;
    Context context;


    public MatchPropertyAdapter(Context context, ArrayList<MyPropertyForDB> matchPropertyLsit) {
        this.matchPropertyLsit = matchPropertyLsit;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view= (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.property,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder viewHolder1 =(ViewHolder)viewHolder;
//        PropertiesDetails propertiesDetails1=propertiesDetails.get(i);
        viewHolder1.id_prop.setText(String.valueOf(matchPropertyLsit.get(i).getPid()));
        viewHolder1.Title.setText(matchPropertyLsit.get(i).getTitle());
        viewHolder1.status.setText(matchPropertyLsit.get(i).getStatus());
        viewHolder1.city.setText(matchPropertyLsit.get(i).getCity());
//        viewHolder1.type.setText(propertiesDetails.get(i).getType());
        viewHolder1.date.setText(matchPropertyLsit.get(i).getDate());
    }

    @Override
    public int getItemCount() {
        if(matchPropertyLsit!=null){
            return matchPropertyLsit.size();
        }
        else {
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        View view;
        TextView id_prop;
        TextView Title;
        TextView status;
        TextView city;
        TextView type;
        TextView date;
        Spinner spinner;



        public ViewHolder(View view) {
            super(view);
            this.view = view;
            id_prop=view.findViewById(R.id.id_property);
            Title=view.findViewById(R.id.title_myProp_2);
            status=view.findViewById(R.id.type_2);
            city=view.findViewById(R.id.location_2);
//            type=view.findViewById(R.id.type_2);
            date=view.findViewById(R.id.calenxder_2);
            spinner=view.findViewById(R.id.dropForProperty);
//            seeMatch=view.findViewById(R.id.seeMatch);

        }



    }
}
