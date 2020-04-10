package com.example.dailynotetaker;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public ArrayList<String> mDataset;
    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textView;
        public MyViewHolder(TextView v)
        {
            super(v);
            textView = v;
        }
    }
    public MyAdapter(ArrayList<String> myDataset)
    {
        mDataset = myDataset;
    }
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        TextView v = (TextView)LayoutInflater.from(parent.getContext()).inflate(R.layout.support_simple_spinner_dropdown_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.textView.setText(mDataset.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
