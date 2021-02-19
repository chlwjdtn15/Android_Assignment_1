package com.example.assignment1;


import java.util.List;

public class OrderList {



    private String dish_name;
    private String drink_name;



    public OrderList (String dish_name, String drink_name ) {

        this.dish_name = dish_name;




        this.drink_name = drink_name;


    }


    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getDrink_name() {
        return drink_name;
    }

    public void setDrink_name(String drink_name) {
        this.drink_name = drink_name;
    }



    @Override
    public String toString() {
        return "OrderList{" +
                "dish_name='" + dish_name + '\'' +
                ", drink_name='" + drink_name + '\'' +
                '}';
    }




}
