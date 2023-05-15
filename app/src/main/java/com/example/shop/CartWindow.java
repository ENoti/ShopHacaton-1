package com.example.shop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class CartWindow extends AppCompatActivity{

    int shop_id;
    ListView listView;
    Shop shop;
    ImageButton btn1;
    Cart cart = ProductsWindow.cart;
    RequestQueue requestQueue;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        shop_id = intent.getIntExtra("shop_id", 0);
        setContentView(R.layout.activity_main3);
        listView = (ListView) findViewById(R.id.listView);
        requestQueue = Volley.newRequestQueue(this);
        button = (Button) findViewById(R.id.buttonForPay);
        button.setOnClickListener(new OnClickCartPay(this,shop_id));
        loadProductsFromCart();
    }
    public void  loadProductsFromCart(){
        ArrayList<Product> products = cart.getProducts();
        ListAdapter adapter = new ListViewAdapterCartProducts(getApplicationContext(),
                R.layout.cart_product,R.id.textViewName,products,cart,shop_id,requestQueue,this);
        listView.setAdapter(adapter);
    }

}
