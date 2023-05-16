package com.example.shop;

import android.content.Intent;
import android.view.View;

public class OnClickCartPay implements View.OnClickListener {
    CartWindow cartWindow;
    int shop_id;

    public OnClickCartPay(CartWindow cartWindow, int shop_id) {
        this.cartWindow = cartWindow;
        this.shop_id = shop_id;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(cartWindow, CardWindow.class);
        intent.putExtra("shop_id",shop_id);
        cartWindow.startActivity(intent);
    }
}
