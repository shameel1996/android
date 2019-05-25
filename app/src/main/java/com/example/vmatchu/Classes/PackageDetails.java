package com.example.vmatchu.Classes;

public class PackageDetails {
    private int pakageType;
    private String Package_price;
    private String Exp_date;
    private int Property_credit;

    public PackageDetails(int pakageType, String package_price, String exp_date, int property_credit) {
        this.pakageType = pakageType;
        Package_price = package_price;
        Exp_date = exp_date;
        Property_credit = property_credit;
    }

    public void setPakageType(int pakageType) {
        this.pakageType = pakageType;
    }

    public void setPackage_price(String package_price) {
        Package_price = package_price;
    }

    public void setExp_date(String exp_date) {
        Exp_date = exp_date;
    }

    public void setProperty_credit(int property_credit) {
        Property_credit = property_credit;
    }

    public int getPakageType() {
        return pakageType;
    }

    public String getPackage_price() {
        return Package_price;
    }

    public String getExp_date() {
        return Exp_date;
    }

    public int getProperty_credit() {
        return Property_credit;
    }
}
