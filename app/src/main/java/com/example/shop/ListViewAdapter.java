package com.example.shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter  extends ArrayAdapter<Shop> {
    int listLayout;
    ArrayList<Shop> usersList;
    Context context;
    Button btn1;
    ShopWindow shopWindow;

    public ListViewAdapter(Context context, int listLayout , int field, ArrayList<Shop> usersList, ShopWindow shopWindow) {
        super(context, listLayout, field, usersList);
        this.context = context;
        this.listLayout=listLayout;
        this.usersList = usersList;
        this.shopWindow = shopWindow;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listViewItem = inflater.inflate(listLayout, null, false);
        TextView name = listViewItem.findViewById(R.id.textViewName);
        TextView address = listViewItem.findViewById(R.id.textViewAddress);
        name.setText(usersList.get(position).getName());
        address.setText(usersList.get(position).getAddress());
        btn1 = (Button) listViewItem.findViewById(R.id.button3);
        btn1.setOnClickListener(new OnClickForProducts(shopWindow,usersList.get(position).getId()));
        return listViewItem;
    }

}