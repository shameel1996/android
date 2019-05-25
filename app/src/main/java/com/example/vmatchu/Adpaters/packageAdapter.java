package com.example.vmatchu.Adpaters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.vmatchu.Classes.PackageDetails;
import com.example.vmatchu.PackageActivity;
import com.example.vmatchu.Pojo.MyPropertyForDB;
import com.example.vmatchu.R;

import java.util.ArrayList;

public class packageAdapter extends RecyclerView.Adapter {

    private ArrayList<PackageDetails> packageDetails;
    private Context context;
    private ArrayAdapter<String> arrayAdapter;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view= (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.buy_packages,viewGroup,false);


        return new PropertyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        PropertyAdapter.ViewHolder viewHolder1 =(PropertyAdapter.ViewHolder)viewHolder;
//        PropertiesDetails propertiesDetails1=propertiesDetails.get(i);
        viewHolder1.id_prop.setText(String.valueOf(packageDetails.get(i).getPakageType()));
        viewHolder1.Title.setText(packageDetails.get(i).getPackage_price());
        viewHolder1.status.setText(packageDetails.get(i).getExp_date());
        viewHolder1.city.setText(packageDetails.get(i).getExp_date());
//        viewHolder1.type.setText(propertiesDetails.get(i).getType());



    }
    public packageAdapter(ArrayAdapter<String> arrayAdapter, Context context, ArrayList<PackageDetails> propertiesDetails) {
        this.packageDetails = propertiesDetails;
        this.context = context;
        this.arrayAdapter=arrayAdapter;
    }


    @Override
    public int getItemCount() {
        return 0;
    }


    public static class ViewHolder1 extends RecyclerView.ViewHolder {


        TextView type_pack,price_pack,exp_date,credit;
                Button btn_package;
                View itemView;




        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;
            type_pack=itemView.findViewById(R.id.type_pack);
            price_pack=itemView.findViewById(R.id.price_pack);
            exp_date=itemView.findViewById(R.id.exp_pack);
            credit=itemView.findViewById(R.id.credit_pack);
            btn_package=itemView.findViewById(R.id.choosePackage);
        }
    }
}
