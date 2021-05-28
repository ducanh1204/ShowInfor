package com.example.showinfor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitService {


    @POST("api/employees/getemployeebyid")
    Call<Employee> postData(@Query("id") int id);

    @POST("api/employees/create")
    Call<String> create(@Body Employee employee);
}
