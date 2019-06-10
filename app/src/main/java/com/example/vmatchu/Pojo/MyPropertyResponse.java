package com.example.vmatchu.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyPropertyResponse {
    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("isClosed")
    @Expose
    private List<MyPropertyIsClosed> isClosed;

    @SerializedName("data")
    @Expose
    private List<MyPropertyData> data;

    @SerializedName("status")
    @Expose
    private List<MyPropertyStatus> status;

    @SerializedName("city")
    @Expose
    private List<MyPropertyCity> city;

    @SerializedName("area")
    @Expose
    private List<MyPropertyArea> area;

    @SerializedName("subArea")
    @Expose
    private List<MyPropertySubArea> sub_area;

    @SerializedName("sector")
    @Expose
    private List<MyPropertySector> sector;

    @SerializedName("garages")
    @Expose
    private List<MyPropertyGarages> garages;

    @SerializedName("bathrooms")
    @Expose
    private List<MyPropertyBathrooms> bathrooms;

    @SerializedName("bedrooms")
    @Expose
    private List<MyPropertyBedrooms> bedrooms;

    @SerializedName("rooms")
    @Expose
    private List<MyPropertyRooms> rooms;

    @SerializedName("description")
    @Expose
    private List<MyPropertyDescription> description;

    @SerializedName("areaType")
    @Expose
    private List<MyPropertyAreaType> areaType;

    @SerializedName("propertyType")
    @Expose
    private List<MyPropertyPropertyType> propertyType;

    @SerializedName("minSize")
    @Expose
    private List<MyPropertyMinSize> minSize;

    @SerializedName("minPrice")
    @Expose
    private List<MyPropertyMinPrice> minPrice;

    @SerializedName("maxSize")
    @Expose
    private List<MyPropertyMaxSize> maxSize;

    @SerializedName("maxPrice")
    @Expose
    private List<MyPropertyMaxPrice> maxPrice;

    public String getError() {
        return error;
    }

    public List<MyPropertyData> getData() {
        return data;
    }

    public List<MyPropertyStatus> getStatus() {
        return status;
    }

    public List<MyPropertyCity> getCity() {
        return city;
    }

    public List<MyPropertyArea> getArea() {
        return area;
    }

    public List<MyPropertySubArea> getSub_area() {
        return sub_area;
    }

    public List<MyPropertySector> getSector() {
        return sector;
    }

    public List<MyPropertyGarages> getGarages() {
        return garages;
    }

    public List<MyPropertyBathrooms> getBathrooms() {
        return bathrooms;
    }

    public List<MyPropertyBedrooms> getBedrooms() {
        return bedrooms;
    }

    public List<MyPropertyRooms> getRooms() {
        return rooms;
    }

    public List<MyPropertyDescription> getDescription() {
        return description;
    }

    public List<MyPropertyAreaType> getAreaType() {
        return areaType;
    }

    public List<MyPropertyPropertyType> getPropertyType() {
        return propertyType;
    }

    public List<MyPropertyMinSize> getMinSize() {
        return minSize;
    }

    public List<MyPropertyMinPrice> getMinPrice() {
        return minPrice;
    }

    public List<MyPropertyMaxSize> getMaxSize() {
        return maxSize;
    }

    public List<MyPropertyMaxPrice> getMaxPrice() {
        return maxPrice;
    }

    public List<MyPropertyIsClosed> getIsClosed() {
        return isClosed;
    }
}
