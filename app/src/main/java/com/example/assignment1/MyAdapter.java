package com.example.assignment1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter<Stirng> extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private ArrayList<Stirng> list;


    MyAdapter(ArrayList<String> list) {

        this.list = (ArrayList<Stirng>) list;
    }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){

            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

            View view = layoutInflater.inflate(R.layout.order_layout, parent, false);

            ViewHolder viewHolder = new ViewHolder(view);


            return viewHolder;
        }

        @Override
        public void onBindViewHolder (@NonNull ViewHolder holder,int position){

            String text = (String) list.get(position);

            holder.dish_Name.setText(text);

        }

        @Override
        public int getItemCount () {
            return list.size();
        }


        public static class ViewHolder extends RecyclerView.ViewHolder {


            TextView dish_Name;



            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                dish_Name = itemView.findViewById(R.id.dish_tv);

            }
        }
    }

