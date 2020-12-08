package com.prady.adda247task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prady.adda247task.jsontopojo.Datum;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder> {

    Context context;
    List<Datum> datumList;

    public MyAdapter(Context context, List<Datum> datumList) {
        this.context = context;
        this.datumList = datumList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_row, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.name.setText(datumList.get(holder.getAdapterPosition()).getName());
        holder.email.setText(datumList.get(holder.getAdapterPosition()).getEmail());
        holder.gender.setText(datumList.get(holder.getAdapterPosition()).getGender());
        holder.status.setText(datumList.get(holder.getAdapterPosition()).getStatus());
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Datum> getDatumList() {
        return datumList;
    }

    public void setDatumList(List<Datum> datumList) {
        this.datumList = datumList;
    }

    @Override
    public int getItemCount() {
        if(datumList!=null)
        return datumList.size();
        return 0;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView name, email, gender, status;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            email = itemView.findViewById(R.id.Email);
            gender = itemView.findViewById(R.id.gender);
            status = itemView.findViewById(R.id.status);
            name = itemView.findViewById(R.id.name);
        }
    }
}
