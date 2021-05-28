package com.example.showinfor;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.Base64;

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
    private static int RESULT_LOAD_IMAGE = 1;
    private String url = "http://192.168.10.128";
    private String photo;

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
        edtIssueDate.addTextChangedListener(new DateFormatTextWatcher(edtIssueDate));
        img = findViewById(R.id.img);

        edtExpireDate.addTextChangedListener(new DateFormatTextWatcher(edtExpireDate));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddData();
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);

            String picturePath = cursor.getString(columnIndex);


            cursor.close();
        }
    }

    private void AddData() {
        Employee employee = new Employee();
        employee.setPhoto("/gGFAAAAAQABkAH0AfQSAlxVPIDiAA7pZEA4ABsiM0BfADiWZIBBAEMmZIDYAFVlZICxAFxxZEDNAGriZICqAGx+ZECVAHP9XYCzAHl6XYB/AIClZICZAIKRZICoAIrxT0DrAJPVZIDmAJRaZIBNAJaxZEC7AJZuVoBqAJcuZICVAJqpZIBeAJ22ZIE2AKlOHEB6AKsyZEBxAKy6ZICCAKwqZIBMALY6ZICjALn1ZEDCALpiZID2AL1OSIE2AL9OOoB/AMS6ZIChANDVQYDwAN3JZIBOAOa6ZIBxAPLCZIBhAPY+T4BQAP69ZIBhAQTCT0CxAQjOZIDeASXuVoC9ASpSZEBAAS27XYEaATNiZEEBATdlZIDfAUFeZEBpAUfRZEBJAUjFM0C3AUpiZICDAU5WZIEJAU5xZECjAVheZEBsAVpSXYEBAWN2ZIDIAWZyZEDoAWZ6T0CVAWlqZIBQAWt6ZICFAWxqZICyAX1xQYB1AY6CZECWAaKKZAD4AZAAtwDYAAA=");
        employee.setFinger("/gGFAAAAAQABkAH0AfQSAlxVPIDiAA7pZEA4ABsiM0BfADiWZIBBAEMmZIDYAFVlZICxAFxxZEDNAGriZICqAGx+ZECVAHP9XYCzAHl6XYB/AIClZICZAIKRZICoAIrxT0DrAJPVZIDmAJRaZIBNAJaxZEC7AJZuVoBqAJcuZICVAJqpZIBeAJ22ZIE2AKlOHEB6AKsyZEBxAKy6ZICCAKwqZIBMALY6ZICjALn1ZEDCALpiZID2AL1OSIE2AL9OOoB/AMS6ZIChANDVQYDwAN3JZIBOAOa6ZIBxAPLCZIBhAPY+T4BQAP69ZIBhAQTCT0CxAQjOZIDeASXuVoC9ASpSZEBAAS27XYEaATNiZEEBATdlZIDfAUFeZEBpAUfRZEBJAUjFM0C3AUpiZICDAU5WZIEJAU5xZECjAVheZEBsAVpSXYEBAWN2ZIDIAWZyZEDoAWZ6T0CVAWlqZIBQAWt6ZICFAWxqZICyAX1xQYB1AY6CZECWAaKKZAD4AZAAtwDYAAA=");
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
                .baseUrl(url)
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
                Toast.makeText(AddDataActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("ERR", t.getMessage());
            }
        });
    }
}