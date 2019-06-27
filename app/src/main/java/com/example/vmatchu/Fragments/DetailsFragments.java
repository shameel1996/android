package com.example.vmatchu.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vmatchu.Models.MyPropertyAreaForDB;
import com.example.vmatchu.Models.MyPropertyAreaTypeForDB;
import com.example.vmatchu.Models.MyPropertyBathroomsForDB;
import com.example.vmatchu.Models.MyPropertyBedroomsForDB;
import com.example.vmatchu.Models.MyPropertyCityForDB;
import com.example.vmatchu.Models.MyPropertyDescriptionForDB;
import com.example.vmatchu.Models.MyPropertyGaragesForDB;
import com.example.vmatchu.Models.MyPropertyPropertyTypeForDB;
import com.example.vmatchu.Models.MyPropertyRoomsForDB;
import com.example.vmatchu.Models.MyPropertySectorsForDB;
import com.example.vmatchu.Models.MyPropertyStatusForDB;
import com.example.vmatchu.Models.MyPropertySubAreaForDB;
import com.example.vmatchu.Pojo.MyPropertyArea;
import com.example.vmatchu.Pojo.MyPropertyAreaType;
import com.example.vmatchu.Pojo.MyPropertyBathrooms;
import com.example.vmatchu.Pojo.MyPropertyBedrooms;
import com.example.vmatchu.Pojo.MyPropertyCity;
import com.example.vmatchu.Pojo.MyPropertyData;
import com.example.vmatchu.Pojo.MyPropertyDescription;
import com.example.vmatchu.Pojo.MyPropertyForDB;
import com.example.vmatchu.Pojo.MyPropertyGarages;
import com.example.vmatchu.Pojo.MyPropertyPropertyType;
import com.example.vmatchu.Pojo.MyPropertyRooms;
import com.example.vmatchu.Pojo.MyPropertySector;
import com.example.vmatchu.Pojo.MyPropertyStatus;
import com.example.vmatchu.Pojo.MyPropertySubArea;
import com.example.vmatchu.R;

import java.util.ArrayList;

public class DetailsFragments extends Fragment {

    ArrayList<MyPropertyData> propertyList;
    ArrayList<MyPropertySector> propertyListSectors;
    ArrayList<MyPropertyGarages> propertyListGarages;
    ArrayList<MyPropertyBathrooms> propertyListBathrooms;
    ArrayList<MyPropertyBedrooms> propertyListBedrooms;
    ArrayList<MyPropertyRooms> propertyListRooms;
    ArrayList<MyPropertyDescription> propertyListDescription;
    ArrayList<MyPropertyCity> propertyListCity;
    ArrayList<MyPropertyArea> propertyListArea;
    ArrayList<MyPropertySubArea> propertyListSubArea;
    ArrayList<MyPropertyAreaType> propertyListAreaType;
    ArrayList<MyPropertyPropertyType> propertyListPropertyType;
    ArrayList<MyPropertyStatus> propertyListStatus;
    TextView status, garages, bathrooms, bedrooms, rooms, propertyType, areaType, pid;
    TextView minSize, minPrice, maxPrice, maxSize;
    String date, propertyCity, propertyArea, propertySubArea, propertySector, propertyGarages, propertyBathrooms, propertyBedrooms;
    String propertyRooms, propertyDesc, propertyAreaType, propertyPropertyType, propertyStatus, propertyId;
    String propertyMinSize, propertyMinSizePid, propertyMinPrice, propertyMinPricePid, propertyMaxSize, propertyMaxSizePid, propertyMaxPrice, propertyMaxPricePid;
    LinearLayout linear_status, linear_price, linear_minPrice, linear_maxPrice, linear_minSize, linear_maxSize, linear_propertyType,
            linear_rooms, linear_bedrooms, linear_bathrooms, linear_garages, linear_areaType;

    public DetailsFragments() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.details_fragment, container, false);
        initialize(v);
        date = getArguments().getString("propertyList");
//        propertyTitle = getArguments().getString("propertyDataTitle");
        propertyGarages = getArguments().getString("propertyListGarages");
        propertyBathrooms = getArguments().getString("propertyListBathrooms");
        propertyBedrooms = getArguments().getString("propertyListBedrooms");
        propertyRooms = getArguments().getString("propertyListRooms");
        propertyDesc = getArguments().getString("propertyListDescription");
        propertySector = getArguments().getString("propertyListSectors");
        propertyCity = getArguments().getString("propertyListCity");
        propertyArea = getArguments().getString("propertyListArea");
        propertySubArea = getArguments().getString("propertyListSubArea");
        propertyAreaType = getArguments().getString("propertyListAreaType");
        propertyPropertyType = getArguments().getString("propertyListPropertyType");
        propertyStatus = getArguments().getString("propertyListStatus");
        propertyMinSize = getArguments().getString("propertyListMinSize");
        propertyMinSizePid = getArguments().getString("propertyListMinSizePid");
        propertyMinPrice = getArguments().getString("propertyListMinPrice");
        propertyMinPricePid = getArguments().getString("propertyListMinPricePid");
        propertyMaxSize = getArguments().getString("propertyListMaxSize");
        propertyMaxSizePid = getArguments().getString("propertyListMaxSizePid");
        propertyMaxPrice = getArguments().getString("propertyListMaxPrice");
        propertyMaxPricePid = getArguments().getString("propertyListMaxPricePid");
        propertyId = getArguments().getString("pid");

        setView();
        return v;
    }

    private void setView() {
        status.setText(propertyStatus);

        if (propertyGarages != null && !propertyGarages.isEmpty()) {
            if(!propertyGarages.equals("")){
                garages.setText(propertyGarages);
            }else{
                linear_garages.setVisibility(View.GONE);
            }

        } else{
            linear_garages.setVisibility(View.GONE);
        }


        if ( propertyBathrooms != null && !propertyBathrooms.isEmpty()) {
            if(!propertyBathrooms.equals("")){
                bathrooms.setText(propertyBathrooms);
            }else{
                linear_bathrooms.setVisibility(View.GONE);
            }

        } else{
            linear_bathrooms.setVisibility(View.GONE);
        }


        if ( propertyBedrooms != null && !propertyBedrooms.isEmpty()) {
            if(!propertyBedrooms.equals("")){
                bedrooms.setText(propertyBedrooms);
            }else{
                linear_bathrooms.setVisibility(View.GONE);
            }

        } else{
            linear_bedrooms.setVisibility(View.GONE);
        }



        if ( propertyRooms != null && !propertyRooms.isEmpty()) {
            if(!propertyRooms.equals("")){
                rooms.setText(propertyRooms);
            }else{
                linear_rooms.setVisibility(View.GONE);
            }

        } else{
            linear_rooms.setVisibility(View.GONE);
        }


        if ( propertyPropertyType != null && !propertyPropertyType.isEmpty()) {
            if(!propertyPropertyType.equals("")){
                propertyType.setText(propertyPropertyType);
            }else{
                linear_areaType.setVisibility(View.GONE);
            }

        } else{
            linear_areaType.setVisibility(View.GONE);
        }

        if ( propertyAreaType != null && !propertyAreaType.isEmpty()) {
            if(!propertyAreaType.equals("")){
                propertyType.setText(propertyAreaType);
            }else{
                linear_propertyType.setVisibility(View.GONE);
            }

        } else{
            linear_propertyType.setVisibility(View.GONE);
        }



        pid.setText(propertyId);

        if (propertyMinSize != null && !propertyMinSize.isEmpty()) {
            if (propertyMinSizePid.equals(propertyId)) {

                minSize.setText(propertyMinSize);

            }else{
                linear_minSize.setVisibility(View.GONE);
            }
        } else {
            linear_minSize.setVisibility(View.GONE);
        }

        if (propertyMinPrice != null && !propertyMinPrice.isEmpty()) {
            if (propertyMinPricePid.equals(propertyId)) {

                minPrice.setText(propertyMinPrice);

            }else{
                linear_minPrice.setVisibility(View.GONE);
            }
        } else {
            linear_minPrice.setVisibility(View.GONE);
        }

        if (propertyMaxSize != null && !propertyMaxSize.isEmpty()) {
            if (propertyMaxSizePid.equals(propertyId)) {

                maxSize.setText(propertyMaxSize);

            }else{
                linear_maxSize.setVisibility(View.GONE);
            }
        } else {
            linear_maxSize.setVisibility(View.GONE);
        }

        if (propertyMaxPrice != null && !propertyMaxPrice.isEmpty()) {
            if (propertyMaxPricePid.equals(propertyId)) {

                maxPrice.setText(propertyMaxPrice);

            }else{
                linear_maxPrice.setVisibility(View.GONE);
            }
        } else {
            linear_maxPrice.setVisibility(View.GONE);
        }
    }

    private void initialize(View v) {
        status = v.findViewById(R.id.status);
        garages = v.findViewById(R.id.garages);
        bathrooms = v.findViewById(R.id.bathrooms);
        bedrooms = v.findViewById(R.id.bedrooms);
        rooms = v.findViewById(R.id.rooms);
        propertyType = v.findViewById(R.id.propertyType);
        areaType = v.findViewById(R.id.areatype);
        pid = v.findViewById(R.id.pid);
        minSize = v.findViewById(R.id.size);
        minPrice = v.findViewById(R.id.minPrice);
        maxPrice = v.findViewById(R.id.maxPrice);
        maxSize = v.findViewById(R.id.maxSize);
        linear_status = v.findViewById(R.id.linear_status);
        linear_price = v.findViewById(R.id.linear_price);
        linear_minPrice = v.findViewById(R.id.linear_min_price);
        linear_maxPrice = v.findViewById(R.id.linear_max_price);
        linear_minSize = v.findViewById(R.id.linear_min_size);
        linear_maxSize = v.findViewById(R.id.linear_max_size);
        linear_propertyType = v.findViewById(R.id.linear_property_type);
        linear_rooms = v.findViewById(R.id.linear_rooms);
        linear_bedrooms = v.findViewById(R.id.linear_bedrooms);
        linear_bathrooms = v.findViewById(R.id.linear_bathrooms);
        linear_garages = v.findViewById(R.id.linear_garages);
        linear_areaType = v.findViewById(R.id.linear_area_type);
    }
}
