package com.example.assignment1;

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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);





    }

    public void open_Summary(View view) {

        Intent intent = new Intent(this, Summary.class);




        if (drink != "" && isCheckboxSelcted() == true){

            getTotalprice();
            isCheckboxSelcted();


            intent.putExtra("drink", drink);
            intent.putExtra("dish", dish);
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

    public void radioButtonChecked(View view) {


        RadioButton radioButton = (RadioButton) view;

    int id = view.getId();

    switch (id) {

        case R.id.tea_radio:

            if (radioButton.isChecked()) {


                drink = "Tea";

                drink_price += 1.7;


            }
            else {
                drink = "";
                drink_price -= 1.7;
            }
            break;

        case R.id.coffe_radio:

            if (radioButton.isChecked()) {

                drink = "Coffee";

                drink_price = 1.8;
            }

            else {

                drink = "";
                drink_price -= 1.8;
            }
            break;
        case R.id.orange_radio:

            if (radioButton.isChecked()) {


                drink = "Orange Juice";

                drink_price = 2;

            }
            else {

                drink = "";
                drink_price -= 2.0;

            }
            break;

        case R.id.apple_raido:

            if (radioButton.isChecked()) {


                drink = "Apple Juice";
                drink_price = 3;
            }

            else {

                drink = "";
                drink_price -= 3.0;
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





                }
                else {

                    dish = "";
                    food_price -= 12;
                    fish = false;



                }
                break;

            case R.id.chicken_cb:

                if (checkBox.isChecked()) {

                    dish = "Chicken";
                    food_price += 11;
                    chicken = true;



                }
                else {

                    dish = "";
                    food_price -= 11;
                    chicken = false;


                }
                break;
            case R.id.roasted_veg_cb:

                if (checkBox.isChecked()) {


                    dish = "Roasted Veggies";
                    food_price += 10;
                    veg = true;



                }
                else {

                    dish = "";
                    food_price -= 10;
                    veg = false;


                }
                break;

            case R.id.grilled_steak_cb:

                if (checkBox.isChecked()) {


                    dish = "Grilled Steak";
                    food_price += 15;
                    steak = true;

                }
                else {

                    dish = "";

                    food_price -= 15;

                    steak = false;

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