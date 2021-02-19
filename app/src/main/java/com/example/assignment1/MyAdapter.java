package com.example.assignment1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    List<OrderList> list;

    MyAdapter(List<OrderList> list) {

        this.list = list;
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



            holder.dish_Name.setText(list.get(position).getDish_name());
            holder.drink_Name.setText(list.get(position).getDrink_name());


        }

        @Override
        public int getItemCount () {
            return list.size();
        }


        public static class ViewHolder extends RecyclerView.ViewHolder {


            TextView dish_Name;
            TextView drink_Name;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                dish_Name = itemView.findViewById(R.id.dish_tv);

                drink_Name = itemView.findViewById(R.id.drink_tv);


            }
        }
    }

