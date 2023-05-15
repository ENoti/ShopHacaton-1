package com.example.shop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartMenu extends Activity {
    Button buttonNextCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onStart();
        setContentView(R.layout.activity_main0);
        buttonNextCard = (Button) findViewById(R.id.buttonNextCard);
        buttonNextCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartMenu.this, ShopWindow.class);
                startActivity(intent);
            }
        });
    }
}
