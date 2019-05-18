package com.example.vmatchu.Classes;

public class PropertiesDetails {
    private int id;
    private String ImageURL;
    private String Title;
    private String status;
    private String city;
    private String type;
    private String date;

    public PropertiesDetails() {

    }


    public PropertiesDetails(int id, String imageURL, String title, String status, String city, String type, String date) {
        this.id = id;
        this.ImageURL = imageURL;
        this.Title = title;
        this.status = status;
        this.city = city;
        this.type = type;
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public String getTitle() {
        return Title;
    }

    public String getStatus() {
        return status;
    }

    public String getCity() {
        return city;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }
}
