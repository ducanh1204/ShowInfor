package com.example.showinfor.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.showinfor.DateFormatTextWatcher;
import com.example.showinfor.Model.Employee;
import com.example.showinfor.NetworkIP;
import com.example.showinfor.R;
import com.example.showinfor.Interface.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddDataActivity extends AppCompatActivity {

    private EditText edtNameEn, edtNameVn, edtBod, edtCountry, edtAddress, edtPaperType, edtPassportNumber, edtIssueDate, edtExpireDate, edtCccd, edtCmtc;

    private RadioGroup radioGroup;
    private RadioButton radioButton_male, radioButton_female;
    private Button btnSave;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        edtNameEn = findViewById(R.id.edtNameEn);
        edtNameVn = findViewById(R.id.edtNameVn);
        edtBod = findViewById(R.id.edtBod);
        edtCountry = findViewById(R.id.edtCountry);
        edtAddress = findViewById(R.id.edtAddress);
        edtPaperType = findViewById(R.id.edtPaperType);
        edtPassportNumber = findViewById(R.id.edtPassportNumber);
        edtIssueDate = findViewById(R.id.edtIssueDate);
        edtExpireDate = findViewById(R.id.edtExpireDate);
        edtCccd = findViewById(R.id.edtCccd);
        edtCmtc = findViewById(R.id.edtCmtc);
        radioGroup = findViewById(R.id.radioGroup);
        radioButton_male = findViewById(R.id.radioButton_male);
        radioButton_female = findViewById(R.id.radioButton_female);
        btnSave = findViewById(R.id.btnSave);
        img = findViewById(R.id.img);
        setTitle("Thêm mới bản ghi");

        edtIssueDate.addTextChangedListener(new DateFormatTextWatcher(edtIssueDate));
        edtExpireDate.addTextChangedListener(new DateFormatTextWatcher(edtExpireDate));
        edtBod.addTextChangedListener(new DateFormatTextWatcher(edtBod));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddData();
            }
        });
    }

    private String getGender() {
        if (radioButton_male.isChecked()) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }
    private void AddData() {
        Employee employee = new Employee();
        employee.setPhoto(null);
        employee.setFinger(null);
        if (!edtNameEn.getText().toString().trim().equals("")) {

            employee.setNameEn(edtNameEn.getText().toString().trim());
        }
        if (!edtNameVn.getText().toString().trim().equals("")) {

            employee.setNameVn(edtNameVn.getText().toString().trim());
        }
        if (!edtBod.getText().toString().trim().equals("")) {

            employee.setBod(edtBod.getText().toString().trim());
        }
        if (!edtCountry.getText().toString().trim().equals("")) {

            employee.setCountry(edtCountry.getText().toString().trim());
        }
        if (!edtAddress.getText().toString().trim().equals("")) {

            employee.setAddress(edtAddress.getText().toString().trim());
        }
        if (!edtPaperType.getText().toString().trim().equals("")) {

            employee.setPaperType(edtPaperType.getText().toString().trim());
        }
        if (!edtPassportNumber.getText().toString().trim().equals("")) {

            employee.setPassportNumber(edtPassportNumber.getText().toString().trim());
        }
        if (!edtIssueDate.getText().toString().trim().equals("")) {

            employee.setIssueDate(edtIssueDate.getText().toString().trim());
        }
        if (!edtExpireDate.getText().toString().trim().equals("")) {

            employee.setExpireDate(edtExpireDate.getText().toString().trim());
        }
        if (!edtCccd.getText().toString().trim().equals("")) {

            employee.setCccd(edtCccd.getText().toString().trim());
        }
        if (!edtCmtc.getText().toString().trim().equals("")) {

            employee.setCmtc(edtCmtc.getText().toString().trim());
        }
        employee.setGender(getGender());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetworkIP.IP)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        retrofitService.create(employee).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(AddDataActivity.this, response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                if (t.getMessage().equals("timeout")) {
                    AddData();
                } else {
                    Toast.makeText(AddDataActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}