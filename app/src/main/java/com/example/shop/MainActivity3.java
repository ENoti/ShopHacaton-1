package com.example.shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity{

    int shop_id;
    ListView listView;
    Shop shop;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        shop_id = intent.getIntExtra("shop_id", 0);
        setContentView(R.layout.activity_main3);
        listView = (ListView) findViewById(R.id.listView);
    }
}
