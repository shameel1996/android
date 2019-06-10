package com.example.vmatchu.Adpaters;

<<<<<<< HEAD
import android.app.Dialog;
=======
import android.app.ProgressDialog;
>>>>>>> af700c286b58570ba248232e10954a4e88aba63a
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
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
<<<<<<< HEAD
=======
import com.example.vmatchu.HomeActivity;
import com.example.vmatchu.Interface.OnItemDeleteClick;
>>>>>>> af700c286b58570ba248232e10954a4e88aba63a
import com.example.vmatchu.MatchPropertyActivity;

import com.example.vmatchu.Models.MyPropertyCityForDB;
import com.example.vmatchu.Models.MyPropertyStatusForDB;
import com.example.vmatchu.Pojo.InsertPropertyResponse;
import com.example.vmatchu.Pojo.MatchedPropertyResponse;

import com.example.vmatchu.PackageActivity;

import com.example.vmatchu.Pojo.MyPropertyArea;
import com.example.vmatchu.Pojo.MyPropertyAreaType;
import com.example.vmatchu.Pojo.MyPropertyBathrooms;
import com.example.vmatchu.Pojo.MyPropertyBedrooms;
import com.example.vmatchu.Pojo.MyPropertyCity;
import com.example.vmatchu.Pojo.MyPropertyData;
import com.example.vmatchu.Pojo.MyPropertyDescription;
import com.example.vmatchu.Pojo.MyPropertyForDB;
import com.example.vmatchu.Pojo.MyPropertyGarages;
import com.example.vmatchu.Pojo.MyPropertyIsClosed;
import com.example.vmatchu.Pojo.MyPropertyMaxPrice;
import com.example.vmatchu.Pojo.MyPropertyMaxSize;
import com.example.vmatchu.Pojo.MyPropertyMinPrice;
import com.example.vmatchu.Pojo.MyPropertyMinSize;
import com.example.vmatchu.Pojo.MyPropertyPropertyType;
import com.example.vmatchu.Pojo.MyPropertyResponse;
import com.example.vmatchu.Pojo.MyPropertyRooms;
import com.example.vmatchu.Pojo.MyPropertySector;
import com.example.vmatchu.Pojo.MyPropertyStatus;
import com.example.vmatchu.Pojo.MyPropertySubArea;
import com.example.vmatchu.PropertyDetailsActivity;
import com.example.vmatchu.R;
import com.example.vmatchu.Rest.APIService;
import com.example.vmatchu.Rest.ApiUtil;
import com.example.vmatchu.SharedPrefs.SaveInSharedPreference;
import com.example.vmatchu.myProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;

public class PropertyAdapter extends RecyclerView.Adapter {
    private List<MyPropertyData> propertiesDetails;
    private List<MyPropertyIsClosed> propertyResponsesListIsClosed;
    private List<MyPropertyCity> propertyResponsesCityList;
    private List<MyPropertyStatus> propertyResponsesStatusList;

    private List<MyPropertyArea> propertyResponsesAreaList1;
    private List<MyPropertySubArea> propertyResponsesSubareaList1;
    private List<MyPropertySector> propertyResponsesSectorList1;
    private List<MyPropertyGarages> propertyResponsesGaragesList1;
    private List<MyPropertyBathrooms> propertyResponsesBathroomList1;
    private List<MyPropertyBedrooms> propertyResponsesBedroomList1;
    private List<MyPropertyRooms> propertyResponsesRoomList1;
    private List<MyPropertyDescription> propertyResponsesDescriptionList1;
    private List<MyPropertyAreaType> propertyResponsesAreaTypeList1;
    private List<MyPropertyPropertyType> propertyResponsesPropertyTypeList1;

    private List<MyPropertyMinSize> propertyResponsesMinSizeList1;
    private List<MyPropertyMinPrice> propertyResponsesMinPriceList1;
    private List<MyPropertyMaxSize> propertyResponsesMaxSizeList1;
    private List<MyPropertyMaxPrice> propertyResponsesMaxPriceList1;
    Context context;
    ArrayAdapter<String> arrayAdapter;
<<<<<<< HEAD
    RecyclerView recyclerView;

=======
    private APIService apiService;
    ProgressDialog progressDialog;
    boolean flag = false;
    OnItemDeleteClick onItemDeleteClick;
>>>>>>> af700c286b58570ba248232e10954a4e88aba63a


    @NonNull
    @Override


    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        final View view = (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.property, viewGroup, false);


        return new ViewHolder(view);
    }

    public PropertyAdapter(ArrayAdapter<String> arrayAdapter, Context context, List<MyPropertyIsClosed> propertyResponsesListIsClosed,
                           List<MyPropertyData> propertiesDetails,
                           List<MyPropertyCity> propertyResponsesCityList,
                           List<MyPropertyStatus> propertyResponsesStatusList, List<MyPropertyArea> propertyResponsesAreaList1,
                           List<MyPropertySubArea> propertyResponsesSubareaList1,
                           List<MyPropertySector> propertyResponsesSectorList1,
                           List<MyPropertyGarages> propertyResponsesGaragesList1,
                           List<MyPropertyBathrooms> propertyResponsesBathroomList1,
                           List<MyPropertyBedrooms> propertyResponsesBedroomList1,
                           List<MyPropertyRooms> propertyResponsesRoomList1,
                           List<MyPropertyDescription> propertyResponsesDescriptionList1,
                           List<MyPropertyAreaType> propertyResponsesAreaTypeList1,
                           List<MyPropertyPropertyType> propertyResponsesPropertyTypeList1,
                           List<MyPropertyMinSize> propertyResponsesMinSizeList1,
                           List<MyPropertyMinPrice> propertyResponsesMinPriceList1,
                           List<MyPropertyMaxSize> propertyResponsesMaxSizeList1,
                           List<MyPropertyMaxPrice> propertyResponsesMaxPriceList1) {
        this.propertiesDetails = propertiesDetails;
        this.context = context;
        this.arrayAdapter = arrayAdapter;
        apiService = ApiUtil.getAPIService();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);
        this.propertyResponsesCityList = propertyResponsesCityList;
        this.propertyResponsesStatusList = propertyResponsesStatusList;
        this.propertyResponsesAreaList1 = propertyResponsesAreaList1;
        this.propertyResponsesSubareaList1 = propertyResponsesSubareaList1;
        this.propertyResponsesSectorList1 = propertyResponsesSectorList1;
        this.propertyResponsesGaragesList1 = propertyResponsesGaragesList1;
        this.propertyResponsesBathroomList1 = propertyResponsesBathroomList1;
        this.propertyResponsesBedroomList1 = propertyResponsesBedroomList1;
        this.propertyResponsesRoomList1 = propertyResponsesRoomList1;
        this.propertyResponsesDescriptionList1 = propertyResponsesDescriptionList1;
        this.propertyResponsesAreaTypeList1 = propertyResponsesAreaTypeList1;
        this.propertyResponsesPropertyTypeList1 = propertyResponsesPropertyTypeList1;
        this.propertyResponsesMinSizeList1 = propertyResponsesMinSizeList1;
        this.propertyResponsesMinPriceList1 = propertyResponsesMinPriceList1;
        this.propertyResponsesMaxSizeList1 = propertyResponsesMaxSizeList1;
        this.propertyResponsesMaxPriceList1 = propertyResponsesMaxPriceList1;


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder viewHolder1 = (ViewHolder) viewHolder;
//        PropertiesDetails propertiesDetails1=propertiesDetails.get(i);
        if (propertyResponsesListIsClosed.size() > i) {
            if(propertyResponsesListIsClosed.get(i).getIsClosed().equals("1")){
                viewHolder1.activeOrClosed.setText("Closed");
            }else {
                viewHolder1.activeOrClosed.setText("Active");
            }
        }
        if (propertiesDetails.size() > i) {
            viewHolder1.id_prop.setText(String.valueOf(propertiesDetails.get(i).getPid()));
            viewHolder1.Title.setText(propertiesDetails.get(i).getTitle());
            viewHolder1.date.setText(propertiesDetails.get(i).getPostDate());
        }
        if (propertyResponsesStatusList.size() > i) {
            viewHolder1.status.setText(propertyResponsesStatusList.get(i).getStatus());
        }
        if (propertyResponsesCityList.size() > i) {
            viewHolder1.city.setText(propertyResponsesCityList.get(i).getCity());
        }

//        viewHolder1.type.setText(propertiesDetails.get(i).getType());

        viewHolder1.seeMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MatchPropertyActivity.class);
                intent.putExtra("pid", propertiesDetails.get(i).getPid());
                context.startActivity(intent);
            }
        });

        viewHolder1.Title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PropertyDetailsActivity.class);
                intent.putExtra("matchOrMyProperty", "myProperty");
                intent.putExtra("propertyData", propertiesDetails.get(i).getPostDate());
                intent.putExtra("propertyDataTitle", propertiesDetails.get(i).getTitle());

                if (propertyResponsesCityList.size() > i) {
                    intent.putExtra("propertyListCity", propertyResponsesCityList.get(i).getCity());
                    intent.putExtra("propertyListCityID", propertyResponsesCityList.get(i).getId());
                }

                if (propertyResponsesAreaList1.size() > i) {
                    intent.putExtra("propertyListArea", propertyResponsesAreaList1.get(i).getArea());
                    intent.putExtra("propertyListAreaID", propertyResponsesAreaList1.get(i).getId());
                }

                if (propertyResponsesSubareaList1.size() > i) {
                    intent.putExtra("propertyListSubArea", propertyResponsesSubareaList1.get(i).getSubArea());
                    intent.putExtra("propertyListSubAreaID", propertyResponsesSubareaList1.get(i).getId());
                }

                if (propertyResponsesSectorList1.size() > i) {
                    intent.putExtra("propertyListSector", propertyResponsesSectorList1.get(i).getSector());
                    intent.putExtra("propertyListSectorID", propertyResponsesSectorList1.get(i).getId());
                }

                if (propertyResponsesGaragesList1.size() > i) {
                    intent.putExtra("propertyListGarages", propertyResponsesGaragesList1.get(i).getGarages());
                }

                if (propertyResponsesBathroomList1.size() > i) {
                    intent.putExtra("propertyListBathroom", propertyResponsesBathroomList1.get(i).getBathroom());
                }

                if (propertyResponsesBedroomList1.size() > i) {
                    intent.putExtra("propertyListBedroom", propertyResponsesBedroomList1.get(i).getBedroom());
                }

                if (propertyResponsesRoomList1.size() > i) {
                    intent.putExtra("propertyListRoom", propertyResponsesRoomList1.get(i).getRoom());
                }

                if (propertyResponsesDescriptionList1.size() > i) {
                    intent.putExtra("propertyListDescription", propertyResponsesDescriptionList1.get(i).getDescription());
                }

                if (propertyResponsesAreaTypeList1.size() > i) {
                    intent.putExtra("propertyListAreaType", propertyResponsesAreaTypeList1.get(i).getAreaType());
                    intent.putExtra("propertyListAreaTypeID", propertyResponsesAreaTypeList1.get(i).getId());
                }

                if (propertyResponsesPropertyTypeList1.size() > i) {
                    intent.putExtra("propertyListPropertyType", propertyResponsesPropertyTypeList1.get(i).getPropertyType());
                    intent.putExtra("propertyListPropertyTypeID", propertyResponsesPropertyTypeList1.get(i).getId());
                }

                if (propertyResponsesStatusList.size() > i) {
                    intent.putExtra("propertyListStatus", propertyResponsesStatusList.get(i).getStatus());
                    intent.putExtra("propertyListStatusID", propertyResponsesStatusList.get(i).getId());
                }

                if (propertyResponsesMinSizeList1.size() > i) {
                    intent.putExtra("propertyListMinSize", propertyResponsesMinSizeList1.get(i).getMinSize());
                    intent.putExtra("propertyListMinSizePid", propertyResponsesMinSizeList1.get(i).getPid());
                }

                if (propertyResponsesMinPriceList1.size() > i) {
                    intent.putExtra("propertyListMinPrice", propertyResponsesMinPriceList1.get(i).getMinPrice());
                    String pid1 = propertyResponsesMinPriceList1.get(i).getPid();
                    intent.putExtra("propertyListMinPricePid", propertyResponsesMinPriceList1.get(i).getPid());
                }

                if (propertyResponsesMaxSizeList1.size() > i) {
                    intent.putExtra("propertyListMaxSize", propertyResponsesMaxSizeList1.get(i).getMaxSize());
                    intent.putExtra("propertyListMaxSizePid", propertyResponsesMaxSizeList1.get(i).getPid());
                }

                if (propertyResponsesMaxPriceList1.size() > i) {
                    intent.putExtra("propertyListMaxPrice", propertyResponsesMaxPriceList1.get(i).getMaxPrice());
                    intent.putExtra("propertyListMaxPricePid", propertyResponsesMaxPriceList1.get(i).getPid());
                }


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
<<<<<<< HEAD
//        viewHolder1.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
//                if(position == 2){
//                    Intent intent = new Intent(context, EditSellPropertyActivity.class);
//                    intent.putExtra("pid", propertiesDetails.get(i).getPid());
//                    context.startActivity(intent);
//                }
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//
//            }
//
//        });
//
//
//        viewHolder1.spinner.setAdapter(arrayAdapter);

        viewHolder1.spinner.setOnClickListener(new View.OnClickListener() {
=======
        viewHolder1.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                if (position == 2) {

                    if (propertyResponsesStatusList.get(i).getStatus().equals("Want Buy")) {
                        Intent intent = new Intent(context, EditPurchasePropertyActivity.class);
                        intent.putExtra("propertyData", propertiesDetails.get(i).getPostDate());
                        intent.putExtra("propertyDataTitle", propertiesDetails.get(i).getTitle());
                        if (propertyResponsesCityList.size() > i) {
                            intent.putExtra("propertyListCity", propertyResponsesCityList.get(i).getCity());
                            intent.putExtra("propertyListCityID", propertyResponsesCityList.get(i).getId());
                        }

                        if (propertyResponsesAreaList1.size() > i) {
                            intent.putExtra("propertyListArea", propertyResponsesAreaList1.get(i).getArea());
                            intent.putExtra("propertyListAreaID", propertyResponsesAreaList1.get(i).getId());
                        }

                        if (propertyResponsesSubareaList1.size() > i) {
                            intent.putExtra("propertyListSubArea", propertyResponsesSubareaList1.get(i).getSubArea());
                            intent.putExtra("propertyListSubAreaID", propertyResponsesSubareaList1.get(i).getId());
                        }

                        if (propertyResponsesSectorList1.size() > i) {
                            intent.putExtra("propertyListSector", propertyResponsesSectorList1.get(i).getSector());
                            intent.putExtra("propertyListSectorID", propertyResponsesSectorList1.get(i).getId());
                        }

                        if (propertyResponsesGaragesList1.size() > i) {
                            intent.putExtra("propertyListGarages", propertyResponsesGaragesList1.get(i).getGarages());
                        }

                        if (propertyResponsesBathroomList1.size() > i) {
                            intent.putExtra("propertyListBathroom", propertyResponsesBathroomList1.get(i).getBathroom());
                        }

                        if (propertyResponsesBedroomList1.size() > i) {
                            intent.putExtra("propertyListBedroom", propertyResponsesBedroomList1.get(i).getBedroom());
                        }

                        if (propertyResponsesRoomList1.size() > i) {
                            intent.putExtra("propertyListRoom", propertyResponsesRoomList1.get(i).getRoom());
                        }

                        if (propertyResponsesDescriptionList1.size() > i) {
                            intent.putExtra("propertyListDescription", propertyResponsesDescriptionList1.get(i).getDescription());
                        }

                        if (propertyResponsesAreaTypeList1.size() > i) {
                            intent.putExtra("propertyListAreaType", propertyResponsesAreaTypeList1.get(i).getAreaType());
                            intent.putExtra("propertyListAreaTypeID", propertyResponsesAreaTypeList1.get(i).getId());
                        }

                        if (propertyResponsesPropertyTypeList1.size() > i) {
                            intent.putExtra("propertyListPropertyType", propertyResponsesPropertyTypeList1.get(i).getPropertyType());
                            intent.putExtra("propertyListPropertyTypeID", propertyResponsesPropertyTypeList1.get(i).getId());
                        }

                        if (propertyResponsesStatusList.size() > i) {
                            intent.putExtra("propertyListStatus", propertyResponsesStatusList.get(i).getStatus());
                            intent.putExtra("propertyListStatusID", propertyResponsesStatusList.get(i).getId());
                        }

                        if (propertyResponsesMinSizeList1.size() > i) {
                            intent.putExtra("propertyListMinSize", propertyResponsesMinSizeList1.get(i).getMinSize());
                            intent.putExtra("propertyListMinSizePid", propertyResponsesMinSizeList1.get(i).getPid());
                        }

                        if (propertyResponsesMinPriceList1.size() > i) {
                            intent.putExtra("propertyListMinPrice", propertyResponsesMinPriceList1.get(i).getMinPrice());
                            intent.putExtra("propertyListMinPricePid", propertyResponsesMinPriceList1.get(i).getPid());
                        }

                        if (propertyResponsesMaxSizeList1.size() > i) {
                            intent.putExtra("propertyListMaxSize", propertyResponsesMaxSizeList1.get(i).getMaxSize());
                            intent.putExtra("propertyListMaxSizePid", propertyResponsesMaxSizeList1.get(i).getPid());
                        }

                        if (propertyResponsesMaxPriceList1.size() > i) {
                            intent.putExtra("propertyListMaxPrice", propertyResponsesMaxPriceList1.get(i).getMaxPrice());
                            intent.putExtra("propertyListMaxPricePid", propertyResponsesMaxPriceList1.get(i).getPid());
                        }

                        intent.putExtra("pid", propertiesDetails.get(i).getPid());
                        context.startActivity(intent);
                    } else if (propertyResponsesStatusList.get(i).getStatus().equals("For Sale")) {
                        Intent intent = new Intent(context, EditSellPropertyActivity.class);
                        intent.putExtra("propertyData", propertiesDetails.get(i).getPostDate());
                        intent.putExtra("propertyDataTitle", propertiesDetails.get(i).getTitle());
                        if (propertyResponsesCityList.size() > i) {
                            intent.putExtra("propertyListCity", propertyResponsesCityList.get(i).getCity());
                            intent.putExtra("propertyListCityID", propertyResponsesCityList.get(i).getId());
                        }

                        if (propertyResponsesAreaList1.size() > i) {
                            intent.putExtra("propertyListArea", propertyResponsesAreaList1.get(i).getArea());
                            intent.putExtra("propertyListAreaID", propertyResponsesAreaList1.get(i).getId());
                        }

                        if (propertyResponsesSubareaList1.size() > i) {
                            intent.putExtra("propertyListSubArea", propertyResponsesSubareaList1.get(i).getSubArea());
                            intent.putExtra("propertyListSubAreaID", propertyResponsesSubareaList1.get(i).getId());
                        }

                        if (propertyResponsesSectorList1.size() > i) {
                            intent.putExtra("propertyListSector", propertyResponsesSectorList1.get(i).getSector());
                            intent.putExtra("propertyListSectorID", propertyResponsesSectorList1.get(i).getId());
                        }

                        if (propertyResponsesGaragesList1.size() > i) {
                            intent.putExtra("propertyListGarages", propertyResponsesGaragesList1.get(i).getGarages());
                        }

                        if (propertyResponsesBathroomList1.size() > i) {
                            intent.putExtra("propertyListBathroom", propertyResponsesBathroomList1.get(i).getBathroom());
                        }

                        if (propertyResponsesBedroomList1.size() > i) {
                            intent.putExtra("propertyListBedroom", propertyResponsesBedroomList1.get(i).getBedroom());
                        }

                        if (propertyResponsesRoomList1.size() > i) {
                            intent.putExtra("propertyListRoom", propertyResponsesRoomList1.get(i).getRoom());
                        }

                        if (propertyResponsesDescriptionList1.size() > i) {
                            intent.putExtra("propertyListDescription", propertyResponsesDescriptionList1.get(i).getDescription());
                        }

                        if (propertyResponsesAreaTypeList1.size() > i) {
                            intent.putExtra("propertyListAreaType", propertyResponsesAreaTypeList1.get(i).getAreaType());
                            intent.putExtra("propertyListAreaTypeID", propertyResponsesAreaTypeList1.get(i).getId());
                        }

                        if (propertyResponsesPropertyTypeList1.size() > i) {
                            intent.putExtra("propertyListPropertyType", propertyResponsesPropertyTypeList1.get(i).getPropertyType());
                            intent.putExtra("propertyListPropertyTypeID", propertyResponsesPropertyTypeList1.get(i).getId());
                        }

                        if (propertyResponsesStatusList.size() > i) {
                            intent.putExtra("propertyListStatus", propertyResponsesStatusList.get(i).getStatus());
                            intent.putExtra("propertyListStatusID", propertyResponsesStatusList.get(i).getId());
                        }

                        if (propertyResponsesMinSizeList1.size() > i) {
                            intent.putExtra("propertyListMinSize", propertyResponsesMinSizeList1.get(i).getMinSize());
                            intent.putExtra("propertyListMinSizePid", propertyResponsesMinSizeList1.get(i).getPid());
                        }

                        if (propertyResponsesMinPriceList1.size() > i) {
                            intent.putExtra("propertyListMinPrice", propertyResponsesMinPriceList1.get(i).getMinPrice());
                            intent.putExtra("propertyListMinPricePid", propertyResponsesMinPriceList1.get(i).getPid());
                        }

                        if (propertyResponsesMaxSizeList1.size() > i) {
                            intent.putExtra("propertyListMaxSize", propertyResponsesMaxSizeList1.get(i).getMaxSize());
                            intent.putExtra("propertyListMaxSizePid", propertyResponsesMaxSizeList1.get(i).getPid());
                        }

                        if (propertyResponsesMaxPriceList1.size() > i) {
                            intent.putExtra("propertyListMaxPrice", propertyResponsesMaxPriceList1.get(i).getMaxPrice());
                            intent.putExtra("propertyListMaxPricePid", propertyResponsesMaxPriceList1.get(i).getPid());
                        }

                        intent.putExtra("pid", propertiesDetails.get(i).getPid());
                        context.startActivity(intent);
                    } else if (propertyResponsesStatusList.get(i).getStatus().equals("For Rent")) {
                        Intent intent = new Intent(context, EditSellPropertyActivity.class);
                        intent.putExtra("propertyData", propertiesDetails.get(i).getPostDate());
                        intent.putExtra("propertyDataTitle", propertiesDetails.get(i).getTitle());
                        if (propertyResponsesCityList.size() > i) {
                            intent.putExtra("propertyListCity", propertyResponsesCityList.get(i).getCity());
                            intent.putExtra("propertyListCityID", propertyResponsesCityList.get(i).getId());
                        }

                        if (propertyResponsesAreaList1.size() > i) {
                            intent.putExtra("propertyListArea", propertyResponsesAreaList1.get(i).getArea());
                            intent.putExtra("propertyListAreaID", propertyResponsesAreaList1.get(i).getId());
                        }

                        if (propertyResponsesSubareaList1.size() > i) {
                            intent.putExtra("propertyListSubArea", propertyResponsesSubareaList1.get(i).getSubArea());
                            intent.putExtra("propertyListSubAreaID", propertyResponsesSubareaList1.get(i).getId());
                        }

                        if (propertyResponsesSectorList1.size() > i) {
                            intent.putExtra("propertyListSector", propertyResponsesSectorList1.get(i).getSector());
                            intent.putExtra("propertyListSectorID", propertyResponsesSectorList1.get(i).getId());
                        }

                        if (propertyResponsesGaragesList1.size() > i) {
                            intent.putExtra("propertyListGarages", propertyResponsesGaragesList1.get(i).getGarages());
                        }

                        if (propertyResponsesBathroomList1.size() > i) {
                            intent.putExtra("propertyListBathroom", propertyResponsesBathroomList1.get(i).getBathroom());
                        }

                        if (propertyResponsesBedroomList1.size() > i) {
                            intent.putExtra("propertyListBedroom", propertyResponsesBedroomList1.get(i).getBedroom());
                        }

                        if (propertyResponsesRoomList1.size() > i) {
                            intent.putExtra("propertyListRoom", propertyResponsesRoomList1.get(i).getRoom());
                        }

                        if (propertyResponsesDescriptionList1.size() > i) {
                            intent.putExtra("propertyListDescription", propertyResponsesDescriptionList1.get(i).getDescription());
                        }

                        if (propertyResponsesAreaTypeList1.size() > i) {
                            intent.putExtra("propertyListAreaType", propertyResponsesAreaTypeList1.get(i).getAreaType());
                            intent.putExtra("propertyListAreaTypeID", propertyResponsesAreaTypeList1.get(i).getId());
                        }

                        if (propertyResponsesPropertyTypeList1.size() > i) {
                            intent.putExtra("propertyListPropertyType", propertyResponsesPropertyTypeList1.get(i).getPropertyType());
                            intent.putExtra("propertyListPropertyTypeID", propertyResponsesPropertyTypeList1.get(i).getId());
                        }

                        if (propertyResponsesStatusList.size() > i) {
                            intent.putExtra("propertyListStatus", propertyResponsesStatusList.get(i).getStatus());
                            intent.putExtra("propertyListStatusID", propertyResponsesStatusList.get(i).getId());
                        }

                        if (propertyResponsesMinSizeList1.size() > i) {
                            intent.putExtra("propertyListMinSize", propertyResponsesMinSizeList1.get(i).getMinSize());
                            intent.putExtra("propertyListMinSizePid", propertyResponsesMinSizeList1.get(i).getPid());
                        }

                        if (propertyResponsesMinPriceList1.size() > i) {
                            intent.putExtra("propertyListMinPrice", propertyResponsesMinPriceList1.get(i).getMinPrice());
                            intent.putExtra("propertyListMinPricePid", propertyResponsesMinPriceList1.get(i).getPid());
                        }

                        if (propertyResponsesMaxSizeList1.size() > i) {
                            intent.putExtra("propertyListMaxSize", propertyResponsesMaxSizeList1.get(i).getMaxSize());
                            intent.putExtra("propertyListMaxSizePid", propertyResponsesMaxSizeList1.get(i).getPid());
                        }

                        if (propertyResponsesMaxPriceList1.size() > i) {
                            intent.putExtra("propertyListMaxPrice", propertyResponsesMaxPriceList1.get(i).getMaxPrice());
                            intent.putExtra("propertyListMaxPricePid", propertyResponsesMaxPriceList1.get(i).getPid());
                        }

                        intent.putExtra("pid", propertiesDetails.get(i).getPid());
                        context.startActivity(intent);
                    } else if (propertyResponsesStatusList.get(i).getStatus().equals("Want Rent")) {
                        Intent intent = new Intent(context, EditPurchasePropertyActivity.class);
                        intent.putExtra("propertyData", propertiesDetails.get(i).getPostDate());
                        intent.putExtra("propertyDataTitle", propertiesDetails.get(i).getTitle());
                        if (propertyResponsesCityList.size() > i) {
                            intent.putExtra("propertyListCity", propertyResponsesCityList.get(i).getCity());
                            intent.putExtra("propertyListCityID", propertyResponsesCityList.get(i).getId());
                        }

                        if (propertyResponsesAreaList1.size() > i) {
                            intent.putExtra("propertyListArea", propertyResponsesAreaList1.get(i).getArea());
                            intent.putExtra("propertyListAreaID", propertyResponsesAreaList1.get(i).getId());
                        }

                        if (propertyResponsesSubareaList1.size() > i) {
                            intent.putExtra("propertyListSubArea", propertyResponsesSubareaList1.get(i).getSubArea());
                            intent.putExtra("propertyListSubAreaID", propertyResponsesSubareaList1.get(i).getId());
                        }

                        if (propertyResponsesSectorList1.size() > i) {
                            intent.putExtra("propertyListSector", propertyResponsesSectorList1.get(i).getSector());
                            intent.putExtra("propertyListSectorID", propertyResponsesSectorList1.get(i).getId());
                        }

                        if (propertyResponsesGaragesList1.size() > i) {
                            intent.putExtra("propertyListGarages", propertyResponsesGaragesList1.get(i).getGarages());
                        }

                        if (propertyResponsesBathroomList1.size() > i) {
                            intent.putExtra("propertyListBathroom", propertyResponsesBathroomList1.get(i).getBathroom());
                        }

                        if (propertyResponsesBedroomList1.size() > i) {
                            intent.putExtra("propertyListBedroom", propertyResponsesBedroomList1.get(i).getBedroom());
                        }

                        if (propertyResponsesRoomList1.size() > i) {
                            intent.putExtra("propertyListRoom", propertyResponsesRoomList1.get(i).getRoom());
                        }

                        if (propertyResponsesDescriptionList1.size() > i) {
                            intent.putExtra("propertyListDescription", propertyResponsesDescriptionList1.get(i).getDescription());
                        }

                        if (propertyResponsesAreaTypeList1.size() > i) {
                            intent.putExtra("propertyListAreaType", propertyResponsesAreaTypeList1.get(i).getAreaType());
                            intent.putExtra("propertyListAreaTypeID", propertyResponsesAreaTypeList1.get(i).getId());
                        }

                        if (propertyResponsesPropertyTypeList1.size() > i) {
                            intent.putExtra("propertyListPropertyType", propertyResponsesPropertyTypeList1.get(i).getPropertyType());
                            intent.putExtra("propertyListPropertyTypeID", propertyResponsesPropertyTypeList1.get(i).getId());
                        }

                        if (propertyResponsesStatusList.size() > i) {
                            intent.putExtra("propertyListStatus", propertyResponsesStatusList.get(i).getStatus());
                            intent.putExtra("propertyListStatusID", propertyResponsesStatusList.get(i).getId());
                        }

                        if (propertyResponsesMinSizeList1.size() > i) {
                            intent.putExtra("propertyListMinSize", propertyResponsesMinSizeList1.get(i).getMinSize());
                            intent.putExtra("propertyListMinSizePid", propertyResponsesMinSizeList1.get(i).getPid());
                        }

                        if (propertyResponsesMinPriceList1.size() > i) {
                            intent.putExtra("propertyListMinPrice", propertyResponsesMinPriceList1.get(i).getMinPrice());
                            intent.putExtra("propertyListMinPricePid", propertyResponsesMinPriceList1.get(i).getPid());
                        }

                        if (propertyResponsesMaxSizeList1.size() > i) {
                            intent.putExtra("propertyListMaxSize", propertyResponsesMaxSizeList1.get(i).getMaxSize());
                            intent.putExtra("propertyListMaxSizePid", propertyResponsesMaxSizeList1.get(i).getPid());
                        }

                        if (propertyResponsesMaxPriceList1.size() > i) {
                            intent.putExtra("propertyListMaxPrice", propertyResponsesMaxPriceList1.get(i).getMaxPrice());
                            intent.putExtra("propertyListMaxPricePid", propertyResponsesMaxPriceList1.get(i).getPid());
                        }

                        intent.putExtra("pid", propertiesDetails.get(i).getPid());
                        context.startActivity(intent);
                    }

                }

                if (position == 3) {
                    onItemDeleteClick.onItemClick(position, propertiesDetails.get(i).getPid());
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
                }
            }

>>>>>>> af700c286b58570ba248232e10954a4e88aba63a
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.show_city);
                recyclerView = dialog.findViewById(R.id.showCity);
                RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context);
                recyclerView.setLayoutManager(layoutManager);
//                        AlertDialog dialog = builder.create();
//                        builder.setCancelable(false);
//                        builder.setView(view1);


//                        adapter.setItemClick(EnterPropertyDetailActivity.this);


            }
        });

    }

    @Override
    public int getItemCount() {
        if (propertiesDetails != null) {
            return propertiesDetails.size();
        } else {
            return 0;
        }
    }

    public void filterList(ArrayList<MyPropertyData> filterdNames) {
        this.propertiesDetails = filterdNames;
        notifyDataSetChanged();
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
        ImageView spinner;
        Button seeMatch;
        TextView activeOrClosed;


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
            activeOrClosed = view.findViewById(R.id.active_2);

        }


    }

    public void setOnClick(OnItemDeleteClick onItemDeleteClick) {
        this.onItemDeleteClick = onItemDeleteClick;
    }

}
