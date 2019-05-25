package com.example.vmatchu.Rest;

public class ApiUtil {
    private ApiUtil() {}

<<<<<<< HEAD
//    public static final String BASE_URL = "http://192.168.10.15:8080/www/vmatchu/wp-content/plugins/property_uploader/apis/";
    public static final String BASE_URL = "http://vmatchu.com/android/apis/";
=======
    public static final String BASE_URL = "http://192.168.10.35:8080/www/vmatchu/wp-content/plugins/property_uploader/apis/";
//    public static final String BASE_URL = "http://vmatchu.com/android/apis/";
>>>>>>> a1c7e90cbe6668373bcb3bf19b9116eb91d00b90


    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);

    }
}
