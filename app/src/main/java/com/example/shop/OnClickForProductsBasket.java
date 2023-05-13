package com.example.shop;

import android.app.DownloadManager;
import android.content.Context;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class OnClickForProductsBasket implements View.OnClickListener {

    Product product;

    Cart cart;

    int shop_id;

    RequestQueue requestQueue;

    public OnClickForProductsBasket(Product product, Cart cart, int shop_id, RequestQueue requestQueue) {
        this.product = product;
        this.cart = cart;
        this.shop_id = shop_id;
        this.requestQueue = requestQueue;
    }

    @Override
    public void onClick(View v) {
        cart.addProduct(product);
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, "https://881b-194-186-53-99.ngrok-free.app/api/shops/" + shop_id + "/products/" + product.getId(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }
}