package com.example.vmatchu.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    TextView status,garages,bathrooms,bedrooms,rooms,propertyType,areaType,pid;
    TextView minSize,minPrice,maxPrice,maxSize;
    String date,propertyCity,propertyArea,propertySubArea,propertySector,propertyGarages,propertyBathrooms,propertyBedrooms;
    String propertyRooms,propertyDesc,propertyAreaType,propertyPropertyType,propertyStatus,propertyId;
    String propertyMinSize,propertyMinSizePid,propertyMinPrice,propertyMinPricePid,propertyMaxSize ,propertyMaxSizePid ,propertyMaxPrice,propertyMaxPricePid;

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
        propertyBedrooms =  getArguments().getString("propertyListBedrooms");
        propertyRooms = getArguments().getString("propertyListRooms");
        propertyDesc = getArguments().getString("propertyListDescription");
        propertySector = getArguments().getString("propertyListSectors");
        propertyCity = getArguments().getString("propertyListCity");
        propertyArea = getArguments().getString("propertyListArea");
        propertySubArea =  getArguments().getString("propertyListSubArea");
        propertyAreaType = getArguments().getString("propertyListAreaType");
        propertyPropertyType = getArguments().getString("propertyListPropertyType");
        propertyStatus =  getArguments().getString("propertyListStatus");
        propertyMinSize =  getArguments().getString("propertyListMinSize");
        propertyMinSizePid =  getArguments().getString("propertyListMinSizePid");
        propertyMinPrice =  getArguments().getString("propertyListMinPrice");
        propertyMinPricePid =  getArguments().getString("propertyListMinPricePid ");
        propertyMaxSize =  getArguments().getString("propertyListMaxSize");
        propertyMaxSizePid =  getArguments().getString("propertyListMaxSizePid");
        propertyMaxPrice =  getArguments().getString("propertyListMaxPrice");
        propertyMaxPricePid =  getArguments().getString("propertyListMaxPricePid");
        propertyId =  getArguments().getString("pid");

        setView();
        return v;
    }

    private void setView() {
        status.setText(propertyStatus);
        garages.setText(propertyGarages);
        bathrooms.setText(propertyBathrooms);
        bedrooms.setText(propertyBedrooms);
        rooms.setText(propertyRooms);
        propertyType.setText(propertyPropertyType);
        areaType.setText(propertyAreaType);
        pid.setText(propertyId);

        if(propertyMinSizePid.equals(propertyId)){

            minSize.setText(propertyMinSize);

        }else if(propertyMinPricePid.equals(propertyId)){

            minPrice.setText(propertyMinPrice);

        }else if(propertyMaxSizePid.equals(propertyId)){

            maxSize.setText(propertyMaxSize);

        }else if(propertyMaxPricePid.equals(propertyId)){

            maxPrice.setText(propertyMaxPrice);

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
    }
}
