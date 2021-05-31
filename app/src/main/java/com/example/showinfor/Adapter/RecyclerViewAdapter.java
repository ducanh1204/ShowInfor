package com.example.showinfor.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.showinfor.Activity.MainActivity;
import com.example.showinfor.Model.Employee;
import com.example.showinfor.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Employee> employeeList;
    private Context context;

    public RecyclerViewAdapter(List<Employee> employeeList, Context context) {
        this.employeeList = employeeList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerViewAdapter.ViewHolder holder, int position) {
        if(employeeList.size()>0){
            try {
                byte[] imgBytes = Base64.decode(employeeList.get(position).getPhoto(),Base64.DEFAULT);
                Bitmap bitmap = BitmapFactory.decodeByteArray(imgBytes, 0, imgBytes.length);
                if(bitmap==null){
                    Toast.makeText(context, "Không thể tải hình ảnh", Toast.LENGTH_SHORT).show();
                }
                holder.img.setImageBitmap(bitmap);
            }catch (Exception e){
                Toast.makeText(context, "Không thể tải hình ảnh", Toast.LENGTH_SHORT).show();
            }
            holder.tvNameEn.setText("NameEn: "+employeeList.get(position).getNameEn());
            holder.tvNameVn.setText("NameVn: "+employeeList.get(position).getNameVn());
            holder.tvGender.setText("Gender: "+employeeList.get(position).getGender());
            holder.tvBod.setText("Bod: "+employeeList.get(position).getBod());
            holder.tvCountry.setText("Country: "+employeeList.get(position).getCountry());
            holder.tvAddress.setText("Address: "+employeeList.get(position).getAddress());
            holder.tvPaperType.setText("PaperType: "+employeeList.get(position).getPaperType());
            holder.tvPassportNumber.setText("Passport Number: "+employeeList.get(position).getPassportNumber());
            holder.tvIssueDate.setText("Issue Date: "+employeeList.get(position).getIssueDate());
            holder.tvExpireDate.setText("Expire Date: "+employeeList.get(position).getExpireDate());
            holder.tvCccd.setText("Cccd: "+employeeList.get(position).getCccd());
            holder.tvCmtc.setText("Cmtc: "+employeeList.get(position).getCmtc());
        }
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNameEn, tvNameVn, tvGender, tvBod, tvCountry, tvAddress, tvPaperType, tvPassportNumber, tvIssueDate, tvExpireDate, tvCccd, tvCmtc;
        private ImageView img;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tvNameEn = itemView.findViewById(R.id.tvNameEn);
            tvNameVn = itemView.findViewById(R.id.tvNameVn);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvBod = itemView.findViewById(R.id.tvBod);
            tvCountry = itemView.findViewById(R.id.tvCountry);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvPaperType = itemView.findViewById(R.id.tvPaperType);
            tvPassportNumber = itemView.findViewById(R.id.tvPassportNumber);
            tvIssueDate = itemView.findViewById(R.id.tvIssueDate);
            tvExpireDate = itemView.findViewById(R.id.tvExpireDate);
            tvCccd = itemView.findViewById(R.id.tvCccd);
            tvCmtc = itemView.findViewById(R.id.tvCmtc);
        }
    }
}
