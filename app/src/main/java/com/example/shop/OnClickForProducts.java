package com.example.shop;

import android.content.Intent;
import android.view.View;

public class OnClickForProducts implements View.OnClickListener {
    private ShopWindow shopWindow;
    int shop_id;

    public OnClickForProducts(ShopWindow shopWindow, int shop_id) {
        this.shopWindow = shopWindow;
        this.shop_id = shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(shopWindow, ProductsWindow.class);
        intent.putExtra("shop_id",shop_id);
        shopWindow.startActivity(intent);
    }
}
