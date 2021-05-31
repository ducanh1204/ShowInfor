package com.example.showinfor.Interface;

import com.example.showinfor.Model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitService {


    @POST("api/employees/getemployeebyid")
    Call<Employee> postData(@Query("id") int id);

    @POST("api/employees/create")
    Call<String> create(@Body Employee employee);

    @GET("api/employees/getall")
    Call<List<Employee>> getAllData();
}
