package com.example.shop;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.shop.databinding.ActivityCardWindowBinding;

import java.util.ArrayList;

public class CardWindow extends AppCompatActivity {

    static ArrayList<Card> cards = new ArrayList<>();

    Button button;
    ListView listView;
    int shop_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        CardWindow cardWindow = this;
        shop_id = intent.getIntExtra("shop_id", 0);
        setContentView(R.layout.activity_card_window);
        listView = (ListView) findViewById(R.id.listView);
        button = findViewById(R.id.buttonForCreateCard);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(cardWindow,CreateNewCard.class);
                cardWindow.startActivity(intent1);
            }
        });
        loadCards();
    }

    public void loadCards(){
        ListAdapter adapter = new ListViewAdapterForCards(getApplicationContext(),
                R.layout.cards,R.id.textViewName,cards,this);
        listView.setAdapter(adapter);
    }


}