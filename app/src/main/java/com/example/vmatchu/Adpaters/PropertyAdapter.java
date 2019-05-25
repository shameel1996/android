package com.example.vmatchu.Adpaters;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vmatchu.Classes.PackageDetails;
import com.example.vmatchu.Classes.PropertiesDetails;
import com.example.vmatchu.CustomAlert.CustomAlert;
import com.example.vmatchu.EditPurchasePropertyActivity;
import com.example.vmatchu.EditSellPropertyActivity;
import com.example.vmatchu.EnterPropertyDetailActivity;
import com.example.vmatchu.HomeActivity;
import com.example.vmatchu.MatchPropertyActivity;
<<<<<<< HEAD
import com.example.vmatchu.Models.MyPropertyCityForDB;
import com.example.vmatchu.Models.MyPropertyStatusForDB;
import com.example.vmatchu.Pojo.InsertPropertyResponse;
import com.example.vmatchu.Pojo.MatchedPropertyResponse;
=======
import com.example.vmatchu.PackageActivity;
>>>>>>> a1c7e90cbe6668373bcb3bf19b9116eb91d00b90
import com.example.vmatchu.Pojo.MyPropertyForDB;
import com.example.vmatchu.Pojo.MyPropertyResponse;
import com.example.vmatchu.PropertyDetailsActivity;
import com.example.vmatchu.R;
import com.example.vmatchu.Rest.APIService;
import com.example.vmatchu.Rest.ApiUtil;
import com.example.vmatchu.SharedPrefs.SaveInSharedPreference;
import com.example.vmatchu.myProperty;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;

public class PropertyAdapter extends RecyclerView.Adapter {
    private ArrayList<MyPropertyForDB> propertiesDetails;
    private ArrayList<MyPropertyCityForDB> propertyResponsesCityList ;
    private ArrayList<MyPropertyStatusForDB> propertyResponsesStatusList ;
    Context context;
    ArrayAdapter<String> arrayAdapter;
    private APIService apiService;
    ProgressDialog progressDialog;


    @NonNull
    @Override


    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        final View view = (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.property, viewGroup, false);


        return new ViewHolder(view);
    }

    public PropertyAdapter(ArrayAdapter<String> arrayAdapter, Context context, ArrayList<MyPropertyForDB> propertiesDetails,
                           ArrayList<MyPropertyCityForDB> propertyResponsesCityList,
                           ArrayList<MyPropertyStatusForDB> propertyResponsesStatusList ) {
        this.propertiesDetails = propertiesDetails;
        this.context = context;
        this.arrayAdapter = arrayAdapter;
        apiService = ApiUtil.getAPIService();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);
        this.propertyResponsesCityList = propertyResponsesCityList;
        this.propertyResponsesStatusList = propertyResponsesStatusList;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder viewHolder1 = (ViewHolder) viewHolder;
//        PropertiesDetails propertiesDetails1=propertiesDetails.get(i);
        viewHolder1.id_prop.setText(String.valueOf(propertiesDetails.get(i).getPid()));
        viewHolder1.Title.setText(propertiesDetails.get(i).getTitle());
        viewHolder1.status.setText(propertyResponsesStatusList.get(i).getStatus());
        viewHolder1.city.setText(propertyResponsesCityList.get(i).getCity());
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
                if (position == 2) {

                    if (propertyResponsesStatusList.get(i).getStatus().equals("Want Buy")) {
                        Intent intent = new Intent(context, EditPurchasePropertyActivity.class);
                        intent.putExtra("pid", propertiesDetails.get(i).getPid());
                        context.startActivity(intent);
                    } else if (propertyResponsesStatusList.get(i).getStatus().equals("For Sale")) {
                        Intent intent = new Intent(context, EditSellPropertyActivity.class);
                        intent.putExtra("pid", propertiesDetails.get(i).getPid());
                        context.startActivity(intent);
                    } else if (propertyResponsesStatusList.get(i).getStatus().equals("For Rent")) {
                        Intent intent = new Intent(context, EditSellPropertyActivity.class);
                        intent.putExtra("pid", propertiesDetails.get(i).getPid());
                        context.startActivity(intent);
                    } else if (propertyResponsesStatusList.get(i).getStatus().equals("Want Rent")) {
                        Intent intent = new Intent(context, EditPurchasePropertyActivity.class);
                        intent.putExtra("pid", propertiesDetails.get(i).getPid());
                        context.startActivity(intent);
                    }

                }

//                if (position == 3) {
//                    AlertDialog.Builder alert;
//                    alert = new AlertDialog.Builder(context);
//                    alert.setMessage("Do You Want To Delete Your Property?");
//                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            progressDialog.show();
//                            Call<InsertPropertyResponse> call = apiService.postDeletePropertyResponse(
//                                    SaveInSharedPreference.getInSharedPreference(context).getUserId(), propertiesDetails.get(i).getPid());
//
//                            call.enqueue(new Callback<InsertPropertyResponse>() {
//
//                                @Override
//                                public void onResponse(Call<InsertPropertyResponse> call, Response<InsertPropertyResponse> response) {
//                                    if (response.isSuccessful()) {
//                                        InsertPropertyResponse insertPropertyResponse = response.body();
//                                        if (insertPropertyResponse.getError().equals("-1")) {
//                                            progressDialog.dismiss();
//                                            AlertDialog.Builder alertDone;
//                                            alertDone = new AlertDialog.Builder(context);
//                                            alertDone.setMessage("Your Property Has Been Deleted");
//                                            alertDone.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                                                @Override
//                                                public void onClick(DialogInterface dialog, int which) {
//
//                                                    context.startActivity(new Intent(context,myProperty.class));
//                                                }
//                                            });
//                                            alertDone.show();
//
//                                        }
//
//                                    }
////
//                                }
//
//
//                                @Override
//                                public void onFailure(Call<InsertPropertyResponse> call, Throwable t) {
//                                    progressDialog.dismiss();
//                                    CustomAlert.alertDialog(context, "Response Failed");
//                                    Log.e("response_Failed", "Unable to submit post to API." + t);
//                                }
//                            });
//                        }
//                    });
//
//                    alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//
//                        }
//                    });
//                    alert.show();
//                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });


        viewHolder1.spinner.setAdapter(arrayAdapter);


    }

    @Override
    public int getItemCount() {
        if (propertiesDetails != null) {
            return propertiesDetails.size();
        } else {
            return 0;
        }
    }
<<<<<<< HEAD
=======
    public void filterList(ArrayList<MyPropertyForDB> filterdNames) {
        this.propertiesDetails = filterdNames;
        notifyDataSetChanged();
    }


>>>>>>> a1c7e90cbe6668373bcb3bf19b9116eb91d00b90

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
            id_prop = view.findViewById(R.id.id_property);
            card = view.findViewById(R.id.card);
            Title = view.findViewById(R.id.title_myProp_2);
            status = view.findViewById(R.id.type_2);
            city = view.findViewById(R.id.location_2);
//            type=view.findViewById(R.id.type_2);
            date = view.findViewById(R.id.calenxder_2);
            spinner = view.findViewById(R.id.dropForProperty);
            seeMatch = view.findViewById(R.id.seeMatch);

        }


    }

}
