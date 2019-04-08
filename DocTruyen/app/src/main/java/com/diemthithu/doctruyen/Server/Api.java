package com.diemthithu.doctruyen.Server;

import com.diemthithu.doctruyen.Model.Response_truyen;
import com.diemthithu.doctruyen.Model.TimKiem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class Api {
    private static Retrofit retrofit;
    private static String DOMAIN="http://192.168.56.1:8080/";
    private static String BASE_URL= DOMAIN + "doctruyen/";

    //khoi tao retrofit
    public static Retrofit getRetrofit(){
        if(retrofit==null){
            retrofit =new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
    public  interface  API{
        @GET("index.php?action=get")
        public Call<Response_truyen> getList(@Query("token") String usertoken,@Query("id") int id);

        @FormUrlEncoded
        @POST("TimKiem.php")
        public  Call<List<TimKiem>> getTimKiem(@Field("tukhoa") String tukhoa);
    }
}
