package com.example.showinfor.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.showinfor.Adapter.RecyclerViewAdapter;
import com.example.showinfor.Interface.RetrofitService;
import com.example.showinfor.Model.Employee;
import com.example.showinfor.NetworkIP;
import com.example.showinfor.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetAllDataActivity extends AppCompatActivity {

    private RecyclerView rvList;
    private List<Employee> employeeList;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_data);
        rvList = findViewById(R.id.rvList);
        setTitle("Tất cả bản ghi");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(linearLayoutManager);
        employeeList = new ArrayList<>();

        getAllData();


    }

    private void getAllData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetworkIP.IP)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        retrofitService.getAllData().enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                if (response.body().size() > 0) {
                    employeeList = response.body();
                    recyclerViewAdapter = new RecyclerViewAdapter(employeeList, GetAllDataActivity.this);
                    rvList.setAdapter(recyclerViewAdapter);
                } else {
                    Toast.makeText(GetAllDataActivity.this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                if (t.getMessage().equals("timeout")) {
                    getAllData();
                } else {
                    Toast.makeText(GetAllDataActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}