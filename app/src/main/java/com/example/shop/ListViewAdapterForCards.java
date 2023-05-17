package com.example.shop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;

import java.util.ArrayList;

public class ListViewAdapterForCards extends ArrayAdapter<Card> {
    private final Context context;
    private final int listLayout;
    private final ArrayList<Card> usersList;

    Button button;

    CardWindow cardWindow;

    public ListViewAdapterForCards(Context context, int listLayout,
                                   int field, ArrayList<Card> usersList, CardWindow cardWindow) {
        super(context, listLayout, field, usersList);
        this.context = context;
        this.listLayout=listLayout;
        this.usersList = usersList;
        this.cardWindow = cardWindow;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listViewItem = inflater.inflate(listLayout, null, false);
        TextView numberCard = listViewItem.findViewById(R.id.textNumberCard);
        TextView bank = listViewItem.findViewById(R.id.textNameBankCard);
        TextView expireDate = listViewItem.findViewById(R.id.textDateCard);
        numberCard.setText(usersList.get(position).textNumberCard);
        bank.setText(usersList.get(position).textNameBankCard);
        expireDate.setText(usersList.get(position).textDateCard);
        button = listViewItem.findViewById(R.id.buttonCardSelect);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(cardWindow,SuccessWindow.class);
            cardWindow.startActivity(intent);
        });
        return listViewItem;
    }
}
