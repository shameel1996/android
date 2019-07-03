package com.example.vmatchu.Adpaters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.vmatchu.Models.MathchedPropertyForDB;
import com.example.vmatchu.Pojo.MyPropertyArea;
import com.example.vmatchu.Pojo.MyPropertyAreaType;
import com.example.vmatchu.Pojo.MyPropertyBathrooms;
import com.example.vmatchu.Pojo.MyPropertyBedrooms;
import com.example.vmatchu.Pojo.MyPropertyCity;
import com.example.vmatchu.Pojo.MyPropertyData;
import com.example.vmatchu.Pojo.MyPropertyDescription;
import com.example.vmatchu.Pojo.MyPropertyGarages;
import com.example.vmatchu.Pojo.MyPropertyPropertyType;
import com.example.vmatchu.Pojo.MyPropertyRooms;
import com.example.vmatchu.Pojo.MyPropertySector;
import com.example.vmatchu.Pojo.MyPropertyStatus;
import com.example.vmatchu.Pojo.MyPropertySubArea;
import com.example.vmatchu.Activities.PropertyDetailsActivity;
import com.example.vmatchu.R;

import java.util.ArrayList;
import java.util.List;

public class MatchPropertyAdapter extends RecyclerView.Adapter{
    private ArrayList<MathchedPropertyForDB> matchPropertyLsit;
    Context context;
    private List<MyPropertyData> propertiesDetails;
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


    public MatchPropertyAdapter(Context context, List<MyPropertyData> propertiesDetails,
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
                                List<MyPropertyPropertyType> propertyResponsesPropertyTypeList1) {
        this.context = context;
        this.propertiesDetails = propertiesDetails;
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
        if(propertiesDetails.size() > i){
            viewHolder1.id_prop.setText(String.valueOf(propertiesDetails.get(i).getPid()));
            viewHolder1.Title.setText(propertiesDetails.get(i).getTitle());
            viewHolder1.date.setText(propertiesDetails.get(i).getPostDate());
        }
        if(propertyResponsesStatusList.size() > i){
            viewHolder1.status.setText(propertyResponsesStatusList.get(i).getStatus());
        }
        if(propertyResponsesCityList.size() > i){
            viewHolder1.city.setText(propertyResponsesCityList.get(i).getCity());
        }

        viewHolder1.Title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PropertyDetailsActivity.class);
                intent.putExtra("matchOrMyProperty", "match");
                intent.putExtra("propertyData", propertiesDetails.get(i).getPostDate());
                intent.putExtra("propertyDataTitle", propertiesDetails.get(i).getTitle());

                if(propertyResponsesCityList.size() > i){
                    intent.putExtra("propertyListCity", propertyResponsesCityList.get(i).getCity());
                    intent.putExtra("propertyListCityID", propertyResponsesCityList.get(i).getId());
                }

                if(propertyResponsesAreaList1.size() > i){
                    intent.putExtra("propertyListArea", propertyResponsesAreaList1.get(i).getArea());
                    intent.putExtra("propertyListAreaID", propertyResponsesAreaList1.get(i).getId());
                }

                if(propertyResponsesSubareaList1.size() >i){
                    intent.putExtra("propertyListSubArea",  propertyResponsesSubareaList1.get(i).getSubArea());
                    intent.putExtra("propertyListSubAreaID",  propertyResponsesSubareaList1.get(i).getId());
                }

                if(propertyResponsesSectorList1.size() > i){
                    intent.putExtra("propertyListSector", propertyResponsesSectorList1.get(i).getSector());
                    intent.putExtra("propertyListSectorID", propertyResponsesSectorList1.get(i).getId());
                }

                if(propertyResponsesGaragesList1.size() > i){
                    intent.putExtra("propertyListGarages", propertyResponsesGaragesList1.get(i).getGarages());
                }

                if(propertyResponsesBathroomList1.size() > i){
                    intent.putExtra("propertyListBathroom", propertyResponsesBathroomList1.get(i).getBathroom());
                }

                if(propertyResponsesBedroomList1.size() > i){
                    intent.putExtra("propertyListBedroom",  propertyResponsesBedroomList1.get(i).getBedroom());
                }

                if(propertyResponsesRoomList1.size() > i){
                    intent.putExtra("propertyListRoom",  propertyResponsesRoomList1.get(i).getRoom());
                }

                if(propertyResponsesDescriptionList1.size() > i){
                    intent.putExtra("propertyListDescription",  propertyResponsesDescriptionList1.get(i).getDescription());
                }

                if(propertyResponsesAreaTypeList1.size() > i){
                    intent.putExtra("propertyListAreaType", propertyResponsesAreaTypeList1.get(i).getAreaType());
                    intent.putExtra("propertyListAreaTypeID", propertyResponsesAreaTypeList1.get(i).getId());
                }

                if(propertyResponsesPropertyTypeList1.size() > i){
                    intent.putExtra("propertyListPropertyType",  propertyResponsesPropertyTypeList1.get(i).getPropertyType());
                    intent.putExtra("propertyListPropertyTypeID",  propertyResponsesPropertyTypeList1.get(i).getId());
                }

                if(propertyResponsesStatusList.size() > i){
                    intent.putExtra("propertyListStatus",  propertyResponsesStatusList.get(i).getStatus());
                    intent.putExtra("propertyListStatusID",  propertyResponsesStatusList.get(i).getId());
                }



                intent.putExtra("pid", propertiesDetails.get(i).getPid());
                context.startActivity(intent);
            }
        });
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
