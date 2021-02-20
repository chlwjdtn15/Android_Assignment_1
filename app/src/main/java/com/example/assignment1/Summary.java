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

    private ArrayList<String> dish_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);




        TextView totalpriceTV = (TextView)findViewById(R.id.total_price_Tv);

        Intent intent = getIntent();


        dish_list = intent.getStringArrayListExtra("dish");
        total_price = intent.getDoubleExtra("price", 0);




        String priceToString = Double.toString(total_price);
        totalpriceTV.setText(priceToString);





        RecyclerView recyclerView = findViewById(R.id.recyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(dish_list));


    }


    public void editOrderBtn(View view) {

        Intent intent = new Intent();


        dish_list.remove("Tea");
        dish_list.remove("Coffee");
        dish_list.remove("Orange Juice");
        dish_list.remove("Apple Juice");

        intent.putStringArrayListExtra("clear_dish", dish_list);

        System.out.println(dish_list);
        setResult(RESULT_OK, intent);
        finish();

    }

    public void summitBtn(View view) {

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}