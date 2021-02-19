package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Summary extends AppCompatActivity {

    int RequestCode = 3;
    String drink = "";
    String dish = "";
    double total_price = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);


        TextView totalpriceTV = (TextView)findViewById(R.id.total_price_Tv);

        Intent intent = getIntent();



        drink = intent.getStringExtra("drink");
        dish = intent.getStringExtra("dish");
        total_price = intent.getDoubleExtra("price", 0);




        String priceToString = Double.toString(total_price);
        totalpriceTV.setText(priceToString);









        RecyclerView recyclerView = findViewById(R.id.recyclerView);


        List<OrderList> list = getData();
        MyAdapter adapter = new MyAdapter(list);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }

    public List<OrderList> getData(){


        List<OrderList> orderLists = new ArrayList<>();



       OrderList o1 = new OrderList(dish, drink);

       orderLists.add(o1);



        return  orderLists;



    }

    public void editOrderBtn(View view) {

        Intent intent = new Intent();

        setResult(RESULT_OK, intent);
        finish();





    }

    public void summitBtn(View view) {

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}