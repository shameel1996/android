package com.example.vmatchu.Rest;

public class ApiUtil {
    private ApiUtil() {}

<<<<<<< HEAD
    public static final String BASE_URL = "http://192.168.10.12:8080/www/vmatchu/wp-content/plugins/property_uploader/apis/";
//    public static final String BASE_URL = "http://vmatchu.com/android/apis/";
=======

//    public static final String BASE_URL = "http://192.168.10.12:8080/www/vmatchu/wp-content/plugins/property_uploader/apis/";
    public static final String BASE_URL = "http://vmatchu.com/android/apis/";

>>>>>>> af700c286b58570ba248232e10954a4e88aba63a


    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);

    }
}
