package com.example.shop;

import android.content.Intent;
import android.view.View;

public class OnClickForProductsBasket implements View.OnClickListener {
    private MainActivity mainActivity2;
    int product_id;
    String name;
    String category;
    int price;
    int amount;

    public OnClickForProductsBasket(MainActivity mainActivity, int shop_id, String name,
                                    String category, int price, int amount) {
        this.mainActivity2 = mainActivity;
        this.product_id = shop_id;
        this.amount = amount;
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mainActivity2, MainActivity3.class);
        intent.putExtra("product_id",product_id);
        intent.putExtra("amount",amount);
        intent.putExtra("category",category);
        intent.putExtra("name",name);
        intent.putExtra("price",price);
        mainActivity2.startActivity(intent);
    }
}