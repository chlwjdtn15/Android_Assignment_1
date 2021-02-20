package com.example.assignment1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    int RequestCode = 3;
    String drink = "";
    String dish = "";
    double drink_price = 0;
    double food_price = 0;
    double total_price = 0;
    Boolean isCbChecked = false;
    Boolean fish = false;
    Boolean chicken = false;
    Boolean veg = false;
    Boolean steak = false;


    private     ArrayList<String> dish_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        dish_list = new ArrayList<>();



    }

    public void open_Summary(View view) {

        Intent intent = new Intent(this, Summary.class);




        if (drink != "" && isCheckboxSelcted() == true){

            getTotalprice();
            isCheckboxSelcted();


            intent.putStringArrayListExtra("dish", dish_list);
            intent.putExtra("price", total_price);


            startActivityForResult(intent, RequestCode);


        }
        else if (drink == "" && isCheckboxSelcted() == true)
        {
            Toast.makeText(this, "Please select drink", Toast.LENGTH_SHORT).show();
        }
        else if (isCheckboxSelcted() == false && drink != "")
        {
            Toast.makeText(this, "Please select your food", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Please select your food", Toast.LENGTH_SHORT).show();
        }




    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        if (requestCode == RequestCode) {
            if (resultCode == RESULT_OK) {
                dish_list = data.getStringArrayListExtra("clear_dish");

                System.out.println(dish_list);
            }
        }
    }

    public void radioButtonChecked(View view) {


        RadioButton radioButton = (RadioButton) view;

    int id = view.getId();

    switch (id) {

        case R.id.tea_radio:

            if (radioButton.isChecked()) {


                drink = "Tea";

               drink_price = 1.7;

                dish_list.add("Tea");

            }
            else {
                drink = "";
                drink_price = -1.7;

                dish_list.remove("Tea");
            }
            break;

        case R.id.coffe_radio:

            if (radioButton.isChecked()) {

                drink = "Coffee";

                drink_price = 1.8;


                dish_list.add("Coffee");
            }

            else {

                drink = "";
                drink_price = -1.8;


                dish_list.remove("Coffee");
            }
            break;
        case R.id.orange_radio:

            if (radioButton.isChecked()) {


                drink = "Orange Juice";

                drink_price = 2;


                dish_list.add("Orange Juice");

            }
            else {

                drink = "";
                drink_price = -2.0;

                dish_list.remove("Orange Juice");

            }
            break;

        case R.id.apple_raido:

            if (radioButton.isChecked()) {


                drink = "Apple Juice";
                drink_price = 3;


                dish_list.add("Apple Juice");
            }

            else {

                drink = "";
                drink_price = -3.0;


                dish_list.remove("Apple Juice");
            }
            break;
        }

    }


    public void dishCbSelected(View view) {

        CheckBox checkBox = (CheckBox) view;



        int id = checkBox.getId();

        switch (id) {

            case R.id.fish_cb:

                if (checkBox.isChecked()) {


                    dish = "Fish";
                    food_price += 12;
                    fish = true;


                    dish_list.add("Fish");


                }
                else {

                    dish = "";
                    food_price -= 12;
                    fish = false;


                    dish_list.remove("Fish");
                }
                break;

            case R.id.chicken_cb:

                if (checkBox.isChecked()) {

                    dish = "Chicken";
                    food_price += 11;
                    chicken = true;

                    dish_list.add("Chicken");

                }
                else {

                    dish = "";
                    food_price -= 11;
                    chicken = false;
                    dish_list.remove("Chicken");

                }
                break;
            case R.id.roasted_veg_cb:

                if (checkBox.isChecked()) {


                    dish = "Roasted Veggies";
                    food_price += 10;
                    veg = true;

                    dish_list.add("Roasted Veggies");

                }
                else {

                    dish = "";
                    food_price -= 10;
                    veg = false;

                    dish_list.remove("Roasted Veggies");
                }
                break;

            case R.id.grilled_steak_cb:

                if (checkBox.isChecked()) {


                    dish = "Grilled Steak";
                    food_price += 15;
                    steak = true;

                    dish_list.add("Grilled Steak");


                }
                else {

                    dish = "";

                    food_price -= 15;

                    steak = false;

                    dish_list.remove("Grilled Steak");

                }
                break;
        }

    }


    public double getTotalprice() {


        total_price = food_price + drink_price;


        return total_price;

    }

    public boolean isCheckboxSelcted() {

        if (fish == false && chicken == false && veg == false && steak == false)
        {
            isCbChecked = false;
        }
        else {
            isCbChecked = true;
        }

        return isCbChecked;

    }




}