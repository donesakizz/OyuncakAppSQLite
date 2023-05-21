package com.example.socmedapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

        List<ModalClass> mList;
        Context context;

public CustomAdapter(List<ModalClass> mList, Context context) {
        this.mList = mList;
        this.context = context;
        }

//SearchFragment için eklendi.
public void setFilteredList(List<ModalClass> filteredList) {
        this.mList = filteredList;
        notifyDataSetChanged();
        }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_file ,parent,false);

        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.imageView.setImageResource(mList.get(position).getImage());
        holder.textView.setText(mList.get(position).getText() );

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    //bu sınıfı IDE kendi oluşturdu hatadan dolayı
    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView =itemView.findViewById((R.id.layoutimageId));
            textView = itemView.findViewById(R.id.nameTextViewId);

        }
    }

}
