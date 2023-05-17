package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class SuccessWindow extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_window);
        button = (Button) findViewById(R.id.buttonBack);
        SuccessWindow successWindow = this;
        button.setOnClickListener(v -> {
            ProductsWindow.cart = new Cart();
            Intent intent = new Intent(successWindow,ShopWindow.class);
            successWindow.startActivity(intent);
        });
    }
}