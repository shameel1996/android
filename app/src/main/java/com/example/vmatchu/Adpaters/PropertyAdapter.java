package com.example.vmatchu.Adpaters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vmatchu.Classes.PropertiesDetails;
import com.example.vmatchu.EditPurchasePropertyActivity;
import com.example.vmatchu.EditSellPropertyActivity;
import com.example.vmatchu.MatchPropertyActivity;
import com.example.vmatchu.Pojo.MyPropertyForDB;
import com.example.vmatchu.Pojo.MyPropertyResponse;
import com.example.vmatchu.PropertyDetailsActivity;
import com.example.vmatchu.R;
import com.example.vmatchu.myProperty;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class PropertyAdapter extends RecyclerView.Adapter {
    private ArrayList<MyPropertyForDB> propertiesDetails;
    Context context;
    ArrayAdapter<String> arrayAdapter;



    @NonNull
    @Override



    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        final View view= (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.property,viewGroup,false);


        return new ViewHolder(view);
    }

    public PropertyAdapter(ArrayAdapter<String> arrayAdapter,Context context,ArrayList<MyPropertyForDB> propertiesDetails) {
        this.propertiesDetails = propertiesDetails;
        this.context = context;
        this.arrayAdapter=arrayAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder viewHolder1 =(ViewHolder)viewHolder;
//        PropertiesDetails propertiesDetails1=propertiesDetails.get(i);
        viewHolder1.id_prop.setText(String.valueOf(propertiesDetails.get(i).getPid()));
        viewHolder1.Title.setText(propertiesDetails.get(i).getTitle());
        viewHolder1.status.setText(propertiesDetails.get(i).getStatus());
        viewHolder1.city.setText(propertiesDetails.get(i).getCity());
//        viewHolder1.type.setText(propertiesDetails.get(i).getType());
        viewHolder1.date.setText(propertiesDetails.get(i).getDate());

        viewHolder1.seeMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MatchPropertyActivity.class);
                intent.putExtra("pid", propertiesDetails.get(i).getPid());
                context.startActivity(intent);
            }
        });

        viewHolder1.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PropertyDetailsActivity.class);
                intent.putExtra("pid", propertiesDetails.get(i).getPid());
                context.startActivity(intent);
            }
        });


        viewHolder1.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                context.startActivity(new Intent(context, PropertyDetailsActivity.class));
            }
        });
        viewHolder1.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                if(position == 2){

                    if(propertiesDetails.get(i).getStatus().equals("Want Buy")){
                        Intent intent = new Intent(context, EditPurchasePropertyActivity.class);
                        intent.putExtra("pid", propertiesDetails.get(i).getPid());
                        context.startActivity(intent);
                    } else if(propertiesDetails.get(i).getStatus().equals("For Sale")){
                        Intent intent = new Intent(context, EditSellPropertyActivity.class);
                        intent.putExtra("pid", propertiesDetails.get(i).getPid());
                        context.startActivity(intent);
                    }  else if(propertiesDetails.get(i).getStatus().equals("For Rent")){
                        Intent intent = new Intent(context, EditSellPropertyActivity.class);
                        intent.putExtra("pid", propertiesDetails.get(i).getPid());
                        context.startActivity(intent);
                    } else if(propertiesDetails.get(i).getStatus().equals("Want Rent")){
                        Intent intent = new Intent(context, EditPurchasePropertyActivity.class);
                        intent.putExtra("pid", propertiesDetails.get(i).getPid());
                        context.startActivity(intent);
                    }

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });


        viewHolder1.spinner.setAdapter(arrayAdapter);




    }

    @Override
    public int getItemCount() {
        if(propertiesDetails!=null){
            return propertiesDetails.size();
        }
        else {
            return 0;
        }
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {


        View view;
        CardView card;
        TextView id_prop;
        TextView Title;
        TextView status;
        TextView city;
        TextView type;
        TextView date;
        Spinner spinner;
        Button seeMatch;



        public ViewHolder(View view) {
            super(view);
            this.view = view;
            id_prop=view.findViewById(R.id.id_property);
            card=view.findViewById(R.id.card);
            Title=view.findViewById(R.id.title_myProp_2);
            status=view.findViewById(R.id.type_2);
            city=view.findViewById(R.id.location_2);
//            type=view.findViewById(R.id.type_2);
            date=view.findViewById(R.id.calenxder_2);
            spinner=view.findViewById(R.id.dropForProperty);
            seeMatch=view.findViewById(R.id.seeMatch);

        }



    }

}
