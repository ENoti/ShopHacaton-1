package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateNewCard extends AppCompatActivity {
    Card card;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_card);
        bt = findViewById(R.id.saveButtonCard);
        CreateNewCard createNewCard = this;
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberCard = findViewById(R.id.textNumberCard);
                EditText nameBankCard = findViewById(R.id.textNameBankCard);
                EditText dateCard = findViewById(R.id.textDateCard);

                card = new Card(numberCard.getText().toString(), nameBankCard.getText().toString(),
                        dateCard.getText().toString());
                CardWindow.cards.add(card);
                Intent intent = new Intent(createNewCard, CardWindow.class);
                createNewCard.startActivity(intent);
            }
        });

    }
}