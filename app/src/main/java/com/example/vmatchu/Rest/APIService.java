package com.example.vmatchu.Rest;

import com.example.vmatchu.Pojo.AreaResponse;
import com.example.vmatchu.Pojo.AreaTypeResponse;
import com.example.vmatchu.Pojo.CityResponse;
import com.example.vmatchu.Pojo.InsertPropertyResponse;
import com.example.vmatchu.Pojo.InsertPurchasePropertyResponse;
import com.example.vmatchu.Pojo.MatchedPropertyResponse;
import com.example.vmatchu.Pojo.MyPropertyResponse;
import com.example.vmatchu.Pojo.PropertyStatusResponse;
import com.example.vmatchu.Pojo.PropertyType;
import com.example.vmatchu.Pojo.RemainingMoneyResponse;
import com.example.vmatchu.Pojo.SectorResponse;
import com.example.vmatchu.Pojo.SubAreaResponse;
import com.example.vmatchu.Pojo.UserLogin;
import com.example.vmatchu.Pojo.UserSignup;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
    @GET("signup.php")
    Call<UserSignup> postSignUp(@Query("username") String username,
                                @Query("email") String email,
                                @Query("password") String password,
                                @Query("registerDate") String date);


    @GET("login.php")
    Call<UserLogin> postLogin(@Query("username") String username,
                              @Query("password") String password);

    @GET("getProperty.php")
    Call<PropertyType> getProperty();


    @GET("addSellProperty.php")
    Call<InsertPropertyResponse> postInsertSellProperty(@Query("propertyTitle") String propertyTitle,
                                                        @Query("userId") String userId, @Query("propertyType") String propertyType,
                                                        @Query("propertyTypeRentOrPurchase") String propertyTypeRentOrPurchase,
                                                        @Query("propertyCountry") String propertyCountry,
                                                        @Query("propertyCity") String propertyCity, @Query("propertyArea") String propertyArea,
                                                        @Query("propertySubArea") String propertySubArea,
                                                        @Query("propertySector") String propertySector,
                                                        @Query("propertyPrice") String propertyPrice,
//                                                    @Field("propertyMaxPrice") String propertyMaxPrice,
                                                        @Query("propertyDetailsSize") String propertyDetailsSize,
//                                                    @Field("propertyDetailsMaxSize") String propertyDetailsMaxSize,
                                                        @Query("propertyDetailsAreaType") String propertyDetailsAreaType,
                                                        @Query("propertyDetailsRooms") String propertyDetailsRooms,
                                                        @Query("propertyDetailsBedrooms") String propertyDetailsBedrooms,
                                                        @Query("propertyDetailsBathrooms") String propertyDetailsBathrooms,
                                                        @Query("propertyDetailsGarages") String propertyDetailsGarages,
                                                        @Query("propertyDescription") String propertyDescription,
                                                        @Query("propertyImage") String propertyImage,
                                                        @Query("propertyVideoUrl") String propertyVideoUrl,
                                                        @Query("propertyImage360Url") String propertyImage360Url,
                                                        @Query("remainingMoney") int remainingMoney);

    @GET("addPurchaseProperty.php")
    Call<InsertPurchasePropertyResponse> postInsertPurchaseProperty(@Query("propertyTitle") String propertyTitle,
                                                                    @Query("userId") String userId, @Query("propertyType") String propertyType,
                                                                    @Query("propertyTypeRentOrPurchase") String propertyTypeRentOrPurchase,
                                                                    @Query("propertyCountry") String propertyCountry,
                                                                    @Query("propertyCity") String propertyCity, @Query("propertyArea") String propertyArea,
                                                                    @Query("propertySubArea") String propertySubArea,
                                                                    @Query("propertySector") String propertySector,
                                                                    @Query("propertyMinPrice") String propertyMinPrice,
                                                                    @Query("propertyMaxPrice") String propertyMaxPrice,
                                                                    @Query("propertyDetailsMinSize") String propertyDetailsMinSize,
                                                                    @Query("propertyDetailsMaxSize") String propertyDetailsMaxSize,
                                                                    @Query("propertyDetailsAreaType") String propertyDetailsAreaType,
                                                                    @Query("propertyDetailsRooms") String propertyDetailsRooms,
                                                                    @Query("propertyDetailsBedrooms") String propertyDetailsBedrooms,
                                                                    @Query("propertyDetailsBathrooms") String propertyDetailsBathrooms,
                                                                    @Query("propertyDetailsGarages") String propertyDetailsGarages,
                                                                    @Query("remainingMoney") int remainingMoney
    );

    @GET("getCities.php")
    Call<CityResponse> getCities();

    @GET("getArea.php")
    Call<AreaResponse> getArea(@Query("cityId") String cityId);

    @GET("getSubArea.php")
    Call<SubAreaResponse> getSubArea(@Query("areaId") String areaId);

    @GET("getSector.php")
    Call<SectorResponse> getSector(@Query("subAreaId") String subAreaId);

    ;

    @GET("getAreaType.php")
    Call<AreaTypeResponse> getAreaType();

    @GET("getPropertyStatus.php")
    Call<PropertyStatusResponse> getPropertyStatus();

    @GET("redirectToWeb.php")
    Call<ResponseBody> postRedirectToWeb(@Query("pid") String pid,
                                         @Query("userId") String userId);

    @GET("listMyProperty.php")
    Call<MyPropertyResponse> getListMyProperty(@Query("userId") String userId);

    @GET("getMatchedProperty.php")
    Call<MatchedPropertyResponse> getMatchingProperty(@Query("userId") String userId,
                                                      @Query("pid") String pid);

    @GET("getRemainingMoney.php")
    Call<RemainingMoneyResponse> getRemainingMoney(@Query("userId") String userId);

    @GET("editPurchaseProperty.php")
    Call<InsertPurchasePropertyResponse> postEditPurchaseProperty(@Query("propertyID") String propertyID,
                                                                  @Query("propertyTitle") String propertyTitle,
                                                                  @Query("userId") String userId,
                                                                  @Query("propertyType") String propertyType,
                                                                  @Query("propertyTypeRentOrPurchase") String propertyTypeRentOrPurchase,
                                                                  @Query("propertyCountry") String propertyCountry,
                                                                  @Query("propertyCity") String propertyCity,
                                                                  @Query("propertyArea") String propertyArea,
                                                                  @Query("propertySubArea") String propertySubArea,
                                                                  @Query("propertySector") String propertySector,
                                                                  @Query("propertyMinPrice") String propertyMinPrice,
                                                                  @Query("propertyMaxPrice") String propertyMaxPrice,
                                                                  @Query("propertyDetailsMinSize") String propertyDetailsMinSize,
                                                                  @Query("propertyDetailsMaxSize") String propertyDetailsMaxSize,
                                                                  @Query("propertyDetailsAreaType") String propertyDetailsAreaType,
                                                                  @Query("propertyDetailsRooms") String propertyDetailsRooms,
                                                                  @Query("propertyDetailsBedrooms") String propertyDetailsBedrooms,
                                                                  @Query("propertyDetailsBathrooms") String propertyDetailsBathrooms,
                                                                  @Query("propertyDetailsGarages") String propertyDetailsGarages,
                                                                  @Query("remainingMoney") int remainingMoney
    );

    @GET("editSellProperty.php")
    Call<InsertPropertyResponse> postEditSellProperty(@Query("propertyTitle") String propertyTitle,
                                                              @Query("userId") String userId, @Query("propertyType") String propertyType,
                                                              @Query("propertyTypeRentOrPurchase") String propertyTypeRentOrPurchase,
                                                              @Query("propertyCountry") String propertyCountry,
                                                              @Query("propertyCity") String propertyCity, @Query("propertyArea") String propertyArea,
                                                              @Query("propertySubArea") String propertySubArea,
                                                              @Query("propertySector") String propertySector,
                                                              @Query("propertyPrice") String propertyMinPrice,
                                                              @Query("propertyDetailsSize") String propertyDetailsMinSize,
                                                              @Query("propertyDetailsAreaType") String propertyDetailsAreaType,
                                                              @Query("propertyDetailsRooms") String propertyDetailsRooms,
                                                              @Query("propertyDetailsBedrooms") String propertyDetailsBedrooms,
                                                              @Query("propertyDetailsBathrooms") String propertyDetailsBathrooms,
                                                              @Query("propertyDetailsGarages") String propertyDetailsGarages,
                                                              @Query("propertyDescription") String propertyDescription,
                                                              @Query("propertyImage") String propertyImage,
                                                              @Query("propertyVideoUrl") String propertyVideoUrl,
                                                              @Query("propertyImage360Url") String propertyImage360Url,
                                                              @Query("remainingMoney") int remainingMoney);

    @GET("deleteProperty.php")
    Call<InsertPropertyResponse> postDeletePropertyResponse(@Query("propertyID") String pid,
                                         @Query("userId") String userId);


}
