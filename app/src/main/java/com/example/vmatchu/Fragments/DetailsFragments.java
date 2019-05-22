package com.example.vmatchu.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vmatchu.Models.MyPropertyBathroomsForDB;
import com.example.vmatchu.Models.MyPropertyBedroomsForDB;
import com.example.vmatchu.Models.MyPropertyDescriptionForDB;
import com.example.vmatchu.Models.MyPropertyGaragesForDB;
import com.example.vmatchu.Models.MyPropertyRoomsForDB;
import com.example.vmatchu.Models.MyPropertySectorsForDB;
import com.example.vmatchu.Pojo.MyPropertyForDB;
import com.example.vmatchu.R;

import java.util.ArrayList;

public class DetailsFragments extends Fragment {

    ArrayList<MyPropertyForDB> propertyList;
    ArrayList<MyPropertySectorsForDB> propertyListSectors;
    ArrayList<MyPropertyGaragesForDB> propertyListGarages;
    ArrayList<MyPropertyBathroomsForDB> propertyListBathrooms;
    ArrayList<MyPropertyBedroomsForDB> propertyListBedrooms;
    ArrayList<MyPropertyRoomsForDB> propertyListRooms;
    ArrayList<MyPropertyDescriptionForDB> propertyListDescription;
    TextView status,garages,bathrooms,bedrooms,rooms,propertyType,areaType,pid;

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
        propertyList = (ArrayList<MyPropertyForDB>) getArguments().getSerializable("propertyList");
        propertyListSectors = (ArrayList<MyPropertySectorsForDB>) getArguments().getSerializable("propertyListSectors");
        propertyListGarages = (ArrayList<MyPropertyGaragesForDB>) getArguments().getSerializable("propertyListGarages");
        propertyListBathrooms = (ArrayList<MyPropertyBathroomsForDB>) getArguments().getSerializable("propertyListBathrooms");
        propertyListBedrooms = (ArrayList<MyPropertyBedroomsForDB>) getArguments().getSerializable("propertyListBedrooms");
        propertyListRooms = (ArrayList<MyPropertyRoomsForDB>) getArguments().getSerializable("propertyListRooms");
        propertyListDescription = (ArrayList<MyPropertyDescriptionForDB>) getArguments().getSerializable("propertyListDescription");

        setView();
        return v;
    }

    private void setView() {
        status.setText(propertyList.get(0).getStatus());
        garages.setText(propertyListGarages.get(0).getGarages());
        bathrooms.setText(propertyListBathrooms.get(0).getBathrooms());
        bedrooms.setText(propertyListBedrooms.get(0).getBedrooms());
        rooms.setText(propertyListRooms.get(0).getRooms());
        propertyType.setText(propertyList.get(0).getPropertyType());
        areaType.setText(propertyList.get(0).getAreaType());
        pid.setText(propertyList.get(0).getPid());
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
    }
}
