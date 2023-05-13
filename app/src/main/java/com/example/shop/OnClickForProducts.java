package com.example.shop;

import android.content.Intent;
import android.view.View;

public class OnClickForProducts implements View.OnClickListener {
    private MainActivity mainActivity;
    int shop_id;

    public OnClickForProducts(MainActivity mainActivity, int shop_id) {
        this.mainActivity = mainActivity;
        this.shop_id = shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mainActivity, MainActivity2.class);
        intent.putExtra("shop_id",shop_id);
        mainActivity.startActivity(intent);
    }
}
