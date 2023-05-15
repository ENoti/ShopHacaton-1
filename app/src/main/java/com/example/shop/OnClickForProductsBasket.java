package com.example.shop;

import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class OnClickForProductsBasket implements View.OnClickListener {

    Product product;

    Cart cart;

    int shop_id;

    RequestQueue requestQueue;

    ProductsWindow productsWindow;

    public OnClickForProductsBasket(Product product, Cart cart, int shop_id, RequestQueue requestQueue, ProductsWindow productsWindow) {
        this.product = product;
        this.cart = cart;
        this.shop_id = shop_id;
        this.requestQueue = requestQueue;
        this.productsWindow = productsWindow;
    }

    @Override
    public void onClick(View v) {
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, "https://aff3-194-186-53-99.ngrok-free.app/api/shops/" + shop_id + "/products/" + product.getId(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                cart.setCurrentPrice(cart.getCurrentPrice() + product.getPrice());
                cart.addProduct(product);
                productsWindow.loadJSONFromURL(ProductsWindow.JSON_URL+shop_id);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }
}