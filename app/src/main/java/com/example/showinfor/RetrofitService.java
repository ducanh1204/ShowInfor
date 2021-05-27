package com.example.showinfor;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitService {

    @POST("api/employees/getemployeebyid")
    Call<Employee> postData(@Body int id);
}
