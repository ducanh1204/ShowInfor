package com.example.showinfor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private TextView tvNameEn, tvNameVn, tvGender, tvBod, tvCountry, tvAddress, tvPaperType, tvPassportNumber, tvIssueDate, tvExpireDate, tvCccd, tvCmtc;
    private ImageView img;
    private String url = "http://192.168.10.128";
    private Button btnGetData,btnAddData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);
        tvNameEn = findViewById(R.id.tvNameEn);
        tvNameVn = findViewById(R.id.tvNameVn);
        tvGender = findViewById(R.id.tvGender);
        tvBod = findViewById(R.id.tvBod);
        tvCountry = findViewById(R.id.tvCountry);
        tvAddress = findViewById(R.id.tvAddress);
        tvPaperType = findViewById(R.id.tvPaperType);
        tvPassportNumber = findViewById(R.id.tvPassportNumber);
        tvIssueDate = findViewById(R.id.tvIssueDate);
        tvExpireDate = findViewById(R.id.tvExpireDate);
        tvCccd = findViewById(R.id.tvCccd);
        tvCmtc = findViewById(R.id.tvCmtc);
        btnGetData = findViewById(R.id.btnGetData);
        btnAddData = findViewById(R.id.btnAddData);

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });

        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddDataActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        retrofitService.postData(19).enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {
                if(response.body()!=null){
                    try {
                        byte[] imgBytes = Base64.decode(response.body().getPhoto(),Base64.DEFAULT);
                        Bitmap bitmap = BitmapFactory.decodeByteArray(imgBytes, 0, imgBytes.length);
                        if(bitmap==null){
                            Toast.makeText(MainActivity.this, "Không thể tải hình ảnh", Toast.LENGTH_SHORT).show();
                        }
                        img.setImageBitmap(bitmap);
                    }catch (Exception e){
                        Toast.makeText(MainActivity.this, "Không thể tải hình ảnh", Toast.LENGTH_SHORT).show();
                    }
                    tvNameEn.setText(response.body().getNameEn());
                    tvNameVn.setText(response.body().getNameVn());
                    tvGender.setText(response.body().getGender());
                    tvBod.setText(response.body().getBod());
                    tvCountry.setText(response.body().getCountry());
                    tvAddress.setText(response.body().getAddress());
                    tvPaperType.setText(response.body().getPaperType());
                    tvPassportNumber.setText(response.body().getPassportNumber());
                    tvIssueDate.setText(response.body().getIssueDate());
                    tvExpireDate.setText(response.body().getExpireDate());
                    tvCccd.setText(response.body().getCccd());
                    tvCmtc.setText(response.body().getCmtc());
                }else {
                    Toast.makeText(MainActivity.this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("ERR",t.getMessage());
            }
        });
    }
}