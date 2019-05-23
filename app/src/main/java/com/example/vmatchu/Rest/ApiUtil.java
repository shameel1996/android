package com.example.vmatchu.Rest;

public class ApiUtil {
    private ApiUtil() {}

    public static final String BASE_URL = "http://192.168.10.35:8080/www/vmatchu/wp-content/plugins/property_uploader/apis/";
//    public static final String BASE_URL = "http://vmatchu.com/android/apis/";


    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);

    }
}
