package com.example.vmatchu.DBhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import com.example.vmatchu.Models.MathchedPropertyForDB;
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
import com.example.vmatchu.Pojo.CityAreaSubareaSectorDetailsResponse;
import com.example.vmatchu.Pojo.MyPropertyForDB;
import com.example.vmatchu.Pojo.MyPropertyResponse;
import com.example.vmatchu.Pojo.PropertyType;
import com.example.vmatchu.Pojo.PropertyTypeData;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {


    // Database Version
    private static final int DATABASE_VERSION = 2; //44

    // Database Name // TODO I make this public for use in another class like DeleteAllData
    public static final String DATABASE_NAME = "VmatchU_DB";

    private static final String TABLE_USER_DETAILS = "userDetails";
    private static final String TABLE_PROPERTY_TYPE = "propertyType";
    private static final String TABLE_CITY = "city";
    private static final String TABLE_AREA = "area";
    private static final String TABLE_SUB_AREA = "subArea";
    private static final String TABLE_SECTOR = "sector";
    private static final String TABLE_AREA_TYPE = "areaType";
    private static final String TABLE_PROPERTY_STATUS = "propertyStatus";
    private static final String TABLE_MY_PROPERTY = "myProperty";
    private static final String TABLE_MATCHED_PROPERTY = "matchProperty";
    private static final String TABLE_MY_PROPERTY_SECTOR = "myPropertySector";
    private static final String TABLE_MY_PROPERTY_GARAGES = "myPropertyGarages";
    private static final String TABLE_MY_PROPERTY_BATHROOMS = "myPropertyBathrooms";
    private static final String TABLE_MY_PROPERTY_BEDROOMS = "myPropertyBedrooms";
    private static final String TABLE_MY_PROPERTY_ROOMS = "myPropertyRooms";
    private static final String TABLE_MY_PROPERTY_DESCRIPTION = "myPropertyDescription";
    private static final String TABLE_MY_PROPERTY_CITY = "myPropertyCity";
    private static final String TABLE_MY_PROPERTY_AREA = "myPropertyArea";
    private static final String TABLE_MY_PROPERTY_SUB_AREA = "myPropertySubArea";
    private static final String TABLE_MY_PROPERTY_AREA_TYPE = "myPropertyAreaType";
    private static final String TABLE_MY_PROPERTY_PROPERTY_TYPE = "myPropertyPropertyType";
    private static final String TABLE_MY_PROPERTY_STATUS = "myPropertyStatus";


    public static String TAG = "VmatchU";
    SQLiteDatabase db;

    private Context context;
    String DB_TABLE;

    public DBhelper(Context context) {

        super(context, DATABASE_NAME , null, DATABASE_VERSION);

        Log.d(TAG, "DBHelper: " + DATABASE_NAME);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        String createUserDetailsTable = "CREATE TABLE IF NOT EXISTS " + TABLE_USER_DETAILS + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "user_id text not null,display_name text not null,user_password text not null,user_email text not null)";

        String createPropertyTypeTable = "CREATE TABLE IF NOT EXISTS " + TABLE_PROPERTY_TYPE + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "term_id text not null,property_name text not null)";

        String createCityTable = "CREATE TABLE IF NOT EXISTS " + TABLE_CITY + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "term_id text not null,property_name text not null)";

        String createAreaTable = "CREATE TABLE IF NOT EXISTS " + TABLE_AREA + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "term_id text not null,property_name text not null)";

        String createSubAreaTable = "CREATE TABLE IF NOT EXISTS " + TABLE_SUB_AREA + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "term_id text not null,property_name text not null)";

        String createSectorTable = "CREATE TABLE IF NOT EXISTS " + TABLE_SECTOR + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "term_id text not null,property_name text not null)";

        String createAreaType = "CREATE TABLE IF NOT EXISTS " + TABLE_AREA_TYPE + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "term_id text not null,property_name text not null)";

        String createPropertyStatus = "CREATE TABLE IF NOT EXISTS " + TABLE_PROPERTY_STATUS + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "term_id text not null,property_name text not null)";

        String createMyPropertyTable = "CREATE TABLE IF NOT EXISTS " + TABLE_MY_PROPERTY + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "pid text, title text, date text , status text, city text, area text, sub_area text, sector text, property_type text, area_type text)";

        String createMatchPropertyTable = "CREATE TABLE IF NOT EXISTS " + TABLE_MATCHED_PROPERTY + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "pid text, title text, post_date text , status text, city text, area text, sub_area text, sector text)";

        String createMyPropertySector = "CREATE TABLE IF NOT EXISTS " + TABLE_MY_PROPERTY_SECTOR + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "pid text, sectors text)";

        String createMyPropertyGarages = "CREATE TABLE IF NOT EXISTS " + TABLE_MY_PROPERTY_GARAGES + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "pid text, garages text)";

        String createMyPropertyBathrooms = "CREATE TABLE IF NOT EXISTS " + TABLE_MY_PROPERTY_BATHROOMS + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "pid text, bathrooms text)";

        String createMyPropertyBedrooms = "CREATE TABLE IF NOT EXISTS " + TABLE_MY_PROPERTY_BEDROOMS + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "pid text, bedrooms text)";

        String createMyPropertyRooms = "CREATE TABLE IF NOT EXISTS " + TABLE_MY_PROPERTY_ROOMS + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "pid text, rooms text)";

        String createMyPropertyDescription = "CREATE TABLE IF NOT EXISTS " + TABLE_MY_PROPERTY_DESCRIPTION + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "pid text, descriptions text)";

        String createMyPropertyCity = "CREATE TABLE IF NOT EXISTS " + TABLE_MY_PROPERTY_CITY + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "pid text, city text)";

        String createMyPropertyArea = "CREATE TABLE IF NOT EXISTS " + TABLE_MY_PROPERTY_AREA + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "pid text, area text)";

        String createMyPropertySubArea = "CREATE TABLE IF NOT EXISTS " + TABLE_MY_PROPERTY_SUB_AREA + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "pid text, sub_area text)";

        String createMyPropertyAreaType = "CREATE TABLE IF NOT EXISTS " + TABLE_MY_PROPERTY_AREA_TYPE + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "pid text, area_type text)";

        String createMyPropertyPropertyType = "CREATE TABLE IF NOT EXISTS " + TABLE_MY_PROPERTY_PROPERTY_TYPE + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "pid text, property_type text)";

        String createMyPropertyStatus = "CREATE TABLE IF NOT EXISTS " + TABLE_MY_PROPERTY_STATUS + " (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "pid text, status text)";




        db.execSQL(createUserDetailsTable);
        db.execSQL(createPropertyTypeTable);
        db.execSQL(createCityTable);
        db.execSQL(createAreaTable);
        db.execSQL(createSubAreaTable);
        db.execSQL(createSectorTable);
        db.execSQL(createAreaType);
        db.execSQL(createPropertyStatus);
        db.execSQL(createMyPropertyTable);
        db.execSQL(createMatchPropertyTable);
        db.execSQL(createMyPropertySector);
        db.execSQL(createMyPropertyGarages);
        db.execSQL(createMyPropertyBathrooms);
        db.execSQL(createMyPropertyBedrooms);
        db.execSQL(createMyPropertyRooms);
        db.execSQL(createMyPropertyDescription);
        db.execSQL(createMyPropertyCity);
        db.execSQL(createMyPropertyArea);
        db.execSQL(createMyPropertySubArea);
        db.execSQL(createMyPropertyAreaType);
        db.execSQL(createMyPropertyPropertyType);
        db.execSQL(createMyPropertyStatus);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
        onCreate(db);
    }


    public void addUserDetails(String user_id, String display_name, String user_password,String user_email) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("user_id", user_id);
        contentValues.put("display_name", display_name);
        contentValues.put("user_password", user_password);
        contentValues.put("user_email", user_email);

        long status = insertTableData(TABLE_USER_DETAILS, contentValues);
        if (status != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }

    public void addPropertyTypeData(String term_id, String property_name) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("term_id", term_id);
        contentValues.put("property_name", property_name);

        long status = insertTableData(TABLE_PROPERTY_TYPE, contentValues);
        if (status != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }

    public ArrayList<PropertyTypeData> getPropertyType() {
        ArrayList<PropertyTypeData> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT term_id, property_name FROM " + TABLE_PROPERTY_TYPE + "";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new PropertyTypeData(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }






    public void addCities(String term_id, String property_name) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("term_id", term_id);
        contentValues.put("property_name", property_name);

        long status = insertTableData(TABLE_CITY, contentValues);
        if (status != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }

    public ArrayList<CityAreaSubareaSectorDetailsResponse> getCities() {
        ArrayList<CityAreaSubareaSectorDetailsResponse> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT term_id, property_name FROM " + TABLE_CITY + "";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new CityAreaSubareaSectorDetailsResponse(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }

    public String getCityById(String term_id) {
        ArrayList<CityAreaSubareaSectorDetailsResponse> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String city = "";
        String query = "SELECT property_name FROM " + TABLE_CITY + " WHERE term_id = "+term_id+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                city = c.getString(0);
//                arrayList.add(new CityAreaSubareaSectorDetailsResponse(c.getString(0),
//                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return city;
    }

    public void addArea(String term_id, String property_name) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("term_id", term_id);
        contentValues.put("property_name", property_name);

        long status = insertTableData(TABLE_AREA, contentValues);
        if (status != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }

    public ArrayList<CityAreaSubareaSectorDetailsResponse> getArea() {
        ArrayList<CityAreaSubareaSectorDetailsResponse> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT term_id, property_name FROM " + TABLE_AREA + "";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new CityAreaSubareaSectorDetailsResponse(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }

    public String getAreaById(String term_id) {
        ArrayList<CityAreaSubareaSectorDetailsResponse> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String area = "";
        String query = "SELECT property_name FROM " + TABLE_AREA + " WHERE term_id = "+term_id+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                area = c.getString(0);
//                arrayList.add(new CityAreaSubareaSectorDetailsResponse(c.getString(0),
//                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return area;
    }

    public void addSubArea(String term_id, String property_name) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("term_id", term_id);
        contentValues.put("property_name", property_name);

        long status = insertTableData(TABLE_SUB_AREA, contentValues);
        if (status != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }

    public ArrayList<CityAreaSubareaSectorDetailsResponse> getSubArea() {
        ArrayList<CityAreaSubareaSectorDetailsResponse> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT term_id, property_name FROM " + TABLE_SUB_AREA + "";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new CityAreaSubareaSectorDetailsResponse(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }

    public String getSubAreaById(String term_id) {
        ArrayList<CityAreaSubareaSectorDetailsResponse> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String sub_area = "";
        String query = "SELECT property_name FROM " + TABLE_SUB_AREA + " WHERE term_id = "+term_id+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                sub_area = c.getString(0);
//                arrayList.add(new CityAreaSubareaSectorDetailsResponse(c.getString(0),
//                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return sub_area;
    }

    public void addSector(String term_id, String property_name) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("term_id", term_id);
        contentValues.put("property_name", property_name);

        long status = insertTableData(TABLE_SECTOR, contentValues);
        if (status != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }

    public ArrayList<CityAreaSubareaSectorDetailsResponse> getSector() {
        ArrayList<CityAreaSubareaSectorDetailsResponse> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT term_id, property_name FROM " + TABLE_SECTOR + "";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new CityAreaSubareaSectorDetailsResponse(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }

    public String getSectorById(String term_id) {
        ArrayList<CityAreaSubareaSectorDetailsResponse> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String sector = "";
        String query = "SELECT property_name FROM " + TABLE_SECTOR + " WHERE term_id = "+term_id+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                sector = c.getString(0);
//                arrayList.add(new CityAreaSubareaSectorDetailsResponse(c.getString(0),
//                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return sector;
    }

    public void addAreaType(String term_id, String property_name) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("term_id", term_id);
        contentValues.put("property_name", property_name);

        long status = insertTableData(TABLE_AREA_TYPE, contentValues);
        if (status != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }

    public ArrayList<CityAreaSubareaSectorDetailsResponse> getAreaType() {
        ArrayList<CityAreaSubareaSectorDetailsResponse> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT term_id, property_name FROM " + TABLE_AREA_TYPE + "";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new CityAreaSubareaSectorDetailsResponse(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }

    public String getAreaTypeById(String term_id) {
        ArrayList<CityAreaSubareaSectorDetailsResponse> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String areaType = "";
        String query = "SELECT property_name FROM " + TABLE_AREA_TYPE + " WHERE term_id = "+term_id+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                areaType = c.getString(0);
//                arrayList.add(new CityAreaSubareaSectorDetailsResponse(c.getString(0),
//                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return areaType;
    }

    public void addPropertyStatus(String term_id, String property_name) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("term_id", term_id);
        contentValues.put("property_name", property_name);

        long status = insertTableData(TABLE_PROPERTY_STATUS, contentValues);
        if (status != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }

    public ArrayList<CityAreaSubareaSectorDetailsResponse> getPropertyStatus() {
        ArrayList<CityAreaSubareaSectorDetailsResponse> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT term_id, property_name FROM " + TABLE_PROPERTY_STATUS + "";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new CityAreaSubareaSectorDetailsResponse(c.getString(1),
                        c.getString(2)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }


    public String getPropertyTypeById(String term_id) {
        ArrayList<CityAreaSubareaSectorDetailsResponse> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String propertyType = "";
        String query = "SELECT property_name FROM " + TABLE_PROPERTY_TYPE + " WHERE term_id = "+term_id+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                propertyType = c.getString(0);
//                arrayList.add(new CityAreaSubareaSectorDetailsResponse(c.getString(0),
//                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return propertyType;
    }


    public void addMyPropertyData(String pid, String title, String date) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("pid", pid);
        contentValues.put("title", title);
        contentValues.put("date", date);
//        contentValues.put("status", status);
//        contentValues.put("city", city);
//        contentValues.put("area", area);
//        contentValues.put("sub_area", sub_area);
//        contentValues.put("sector", sector);
//        contentValues.put("garages", garages);
//        contentValues.put("bathrooms", bathrooms);
//        contentValues.put("bedrooms", bedrooms);
//        contentValues.put("rooms", rooms);
//        contentValues.put("description", description);
//        contentValues.put("area_type", areaType);
//        contentValues.put("property_type", propertyType);


        long insert = insertTableData(TABLE_MY_PROPERTY, contentValues);
        if (insert != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }

    public void addMyPropertySectors(String pid, String sectors) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("pid", pid);
        contentValues.put("sectors", sectors);

        long insert = insertTableData(TABLE_MY_PROPERTY_SECTOR, contentValues);
        if (insert != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }
//
    public void adddMyPropertyGarages(String pid, String garages) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("pid", pid);
        contentValues.put("garages", garages);


        long insert = insertTableData(TABLE_MY_PROPERTY_GARAGES, contentValues);
        if (insert != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }
//
    public void addMyPropertyBathrooms(String pid, String bathrooms) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("pid", pid);
        contentValues.put("bathrooms", bathrooms);

        long insert = insertTableData(TABLE_MY_PROPERTY_BATHROOMS, contentValues);
        if (insert != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }
//
    public void addMyPropertyBedrooms(String pid, String bedrooms) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("pid", pid);
        contentValues.put("bedrooms", bedrooms);


        long insert = insertTableData(TABLE_MY_PROPERTY_BEDROOMS, contentValues);
        if (insert != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }
//
    public void addMyPropertyRooms(String pid, String rooms) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("pid", pid);
        contentValues.put("rooms", rooms);


        long insert = insertTableData(TABLE_MY_PROPERTY_ROOMS, contentValues);
        if (insert != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }
//
    public void addMyPropertyDescription(String pid, String description) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("pid", pid);
        contentValues.put("descriptions", description);


        long insert = insertTableData(TABLE_MY_PROPERTY_DESCRIPTION, contentValues);
        if (insert != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }

    public void addMyPropertyArea(String pid,String area) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("pid", pid);
        contentValues.put("area", area);



        long insert = insertTableData(TABLE_MY_PROPERTY_AREA, contentValues);
        if (insert != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }

    public void addMyPropertySubArea(String pid, String sub_area) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("pid", pid);
        contentValues.put("sub_area", sub_area);



        long insert = insertTableData(TABLE_MY_PROPERTY_SUB_AREA, contentValues);
        if (insert != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }

    public void addMyPropertyAreaType(String pid,String area_type) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("pid", pid);
        contentValues.put("area_type", area_type);


        long insert = insertTableData(TABLE_MY_PROPERTY_AREA_TYPE, contentValues);
        if (insert != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }

    public void addMyPropertyPropertyType(String pid,String property_type) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("pid", pid);
        contentValues.put("property_type", property_type);


        long insert = insertTableData(TABLE_MY_PROPERTY_PROPERTY_TYPE, contentValues);
        if (insert != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }

    public void addMyPropertyStatus(String pid,String status) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("pid", pid);
        contentValues.put("status", status);


        long insert = insertTableData(TABLE_MY_PROPERTY_STATUS, contentValues);
        if (insert != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }

    public void addMyPropertyCity(String pid,String city) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("pid", pid);
        contentValues.put("city", city);



        long insert = insertTableData(TABLE_MY_PROPERTY_CITY, contentValues);
        if (insert != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }



    public ArrayList<MyPropertyForDB> getMyProperty() {
        ArrayList<MyPropertyForDB> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT pid,title,date FROM " + TABLE_MY_PROPERTY + "";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {
                arrayList.add(new MyPropertyForDB(c.getString(0),
                        c.getString(1),
                        c.getString(2)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }


    public ArrayList<MyPropertyForDB> getMyPropertyOnPid(String pid) {
        ArrayList<MyPropertyForDB> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT pid,title,date FROM " + TABLE_MY_PROPERTY + " WHERE pid = "+pid+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {
                arrayList.add(new MyPropertyForDB(c.getString(0),
                        c.getString(1),
                        c.getString(2)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }


    public ArrayList<MyPropertyForDB> getMyPropertyAreaSubAreaSector(String pid) {
        ArrayList<MyPropertyForDB> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT pid,title,date FROM " + TABLE_MY_PROPERTY + " WHERE pid = "+pid+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new MyPropertyForDB(c.getString(0),
                        c.getString(1),
                        c.getString(2)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }

    public ArrayList<MyPropertyCityForDB> getMyPropertyCity() {
        ArrayList<MyPropertyCityForDB> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT pid,city FROM " + TABLE_MY_PROPERTY_CITY + "";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new MyPropertyCityForDB(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }

    public ArrayList<MyPropertyCityForDB> getMyPropertyCityByPid(String pid) {
        ArrayList<MyPropertyCityForDB> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT pid,city FROM " + TABLE_MY_PROPERTY_CITY + " WHERE pid = "+pid+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new MyPropertyCityForDB(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }


    public ArrayList<MyPropertyAreaForDB> getMyPropertyArea(String pid) {
        ArrayList<MyPropertyAreaForDB> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT pid,area FROM " + TABLE_MY_PROPERTY_AREA + " WHERE pid = "+pid+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new MyPropertyAreaForDB(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }


    public ArrayList<MyPropertySubAreaForDB> getMyPropertySubArea(String pid) {
        ArrayList<MyPropertySubAreaForDB> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT pid,sub_area FROM " + TABLE_MY_PROPERTY_SUB_AREA + " WHERE pid = "+pid+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new MyPropertySubAreaForDB(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }


    public ArrayList<MyPropertyAreaTypeForDB> getMyPropertyAreaType(String pid) {
        ArrayList<MyPropertyAreaTypeForDB> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT pid,area_type FROM " + TABLE_MY_PROPERTY_AREA_TYPE + " WHERE pid = "+pid+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new MyPropertyAreaTypeForDB(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }


    public ArrayList<MyPropertyPropertyTypeForDB> getMyPropertyPropertyType(String pid) {
        ArrayList<MyPropertyPropertyTypeForDB> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT pid,property_type FROM " + TABLE_MY_PROPERTY_PROPERTY_TYPE + " WHERE pid = "+pid+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new MyPropertyPropertyTypeForDB(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }


    public ArrayList<MyPropertyStatusForDB> getMyPropertyStatus() {
        ArrayList<MyPropertyStatusForDB> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT pid,status FROM " + TABLE_MY_PROPERTY_STATUS + "";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new MyPropertyStatusForDB(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }

    public ArrayList<MyPropertyStatusForDB> getMyPropertyStatusByPid(String pid) {
        ArrayList<MyPropertyStatusForDB> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT pid,status FROM " + TABLE_MY_PROPERTY_STATUS + " WHERE pid = "+pid+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new MyPropertyStatusForDB(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }


    public ArrayList<MyPropertySectorsForDB> getMyPropertySectors(String pid) {
        ArrayList<MyPropertySectorsForDB> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT pid,sectors FROM " + TABLE_MY_PROPERTY_SECTOR + " WHERE pid = "+pid+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new MyPropertySectorsForDB(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }

    public ArrayList<MyPropertyGaragesForDB> getMyPropertyGarages(String pid) {
        ArrayList<MyPropertyGaragesForDB> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT pid,garages FROM " + TABLE_MY_PROPERTY_GARAGES + " WHERE pid = "+pid+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new MyPropertyGaragesForDB(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }

    public ArrayList<MyPropertyBathroomsForDB> getMyPropertyBathrooms(String pid) {
        ArrayList<MyPropertyBathroomsForDB> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT pid,bathrooms FROM " + TABLE_MY_PROPERTY_BATHROOMS + " WHERE pid = "+pid+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new MyPropertyBathroomsForDB(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }

    public ArrayList<MyPropertyBedroomsForDB> getMyPropertyBedrooms(String pid) {
        ArrayList<MyPropertyBedroomsForDB> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT pid,bedrooms FROM " + TABLE_MY_PROPERTY_BEDROOMS + " WHERE pid = "+pid+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new MyPropertyBedroomsForDB(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }

    public ArrayList<MyPropertyRoomsForDB> getMyPropertyRooms(String pid) {
        ArrayList<MyPropertyRoomsForDB> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT pid,rooms FROM " + TABLE_MY_PROPERTY_ROOMS + " WHERE pid = "+pid+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new MyPropertyRoomsForDB(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }

    public ArrayList<MyPropertyDescriptionForDB> getMyPropertyDescription(String pid) {
        ArrayList<MyPropertyDescriptionForDB> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT pid,descriptions FROM " + TABLE_MY_PROPERTY_DESCRIPTION + " WHERE pid = "+pid+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new MyPropertyDescriptionForDB(c.getString(0),
                        c.getString(1)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }

    public void addMatchedProperty(String pid, String title, String post_date, String status, String city, String area,
                                   String sub_area, String sector) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("pid", pid);
        contentValues.put("title", title);
        contentValues.put("post_date", post_date);
        contentValues.put("status", status);
        contentValues.put("city", city);
        contentValues.put("area", area);
        contentValues.put("sub_area", sub_area);
        contentValues.put("sector", sector);

        long insert = insertTableData(TABLE_MATCHED_PROPERTY, contentValues);
        if (insert != -1) {
            Log.i(TAG, "Row Succesfully Inserted");
        }
    }

    public ArrayList<MathchedPropertyForDB> getMatchProperty(String pid) {
        ArrayList<MathchedPropertyForDB> arrayList = new ArrayList<>();
        db = getWritableDatabase();
        String query = "SELECT pid,title,post_date,status,city FROM " + TABLE_MATCHED_PROPERTY + " WHERE pid = "+pid+"";

        Cursor c = db.rawQuery(query, null);
        if (c != null && c.moveToFirst()) {
            do {

                arrayList.add(new MathchedPropertyForDB(c.getString(0),
                        c.getString(1),
                        c.getString(2),
                        c.getString(3),
                        c.getString(4)));

            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arrayList;
    }


    public long insertTableData(String tablename, ContentValues values)
            throws SQLException {
        DB_TABLE = tablename;
        db = this.getWritableDatabase();
        long returnValue = db.insert(DB_TABLE, null, values);
        db.close();
        return returnValue;
    }

    public void emptyTable(String tablename)
            throws SQLException {
        DB_TABLE = tablename;
        db = this.getWritableDatabase();
        db.delete(DB_TABLE, null, null);
//        db.execSQL("delete from "+ DB_TABLE);
        db.close();
    }

}
