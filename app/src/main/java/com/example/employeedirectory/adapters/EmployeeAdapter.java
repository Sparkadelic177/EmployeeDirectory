package com.example.employeedirectory.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.employeedirectory.R;
import com.example.employeedirectory.models.Employees;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder>  {
    Context context;
    List<Employees> employees;

    public EmployeeAdapter(Context context, List<Employees> employees) {
        this.context = context;
        this.employees = employees;
    }

    //Usually involves inflating the layout from xml and returning the holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieView = LayoutInflater.from(context).inflate(R.layout.employee_list_item, parent, false);
        return new ViewHolder(movieView);
    }

    //involves populating data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get the movie at the passed position
        Employees employee = employees.get(position);
        //bind the movie data in the ViewHolder
        holder.bind(employee);
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvTeam;
        ImageView ivPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvTeam = itemView.findViewById(R.id.tvTeam);
            ivPhoto = itemView.findViewById(R.id.ivPhoto);
        }

        public void bind(Employees employee) {
            tvName.setText(employee.getFull_name());
            tvTeam.setText(employee.getTeam());
            Glide.with(context).load(employee.getPhoto_url_small()).into(ivPhoto);
        }

    }
}
