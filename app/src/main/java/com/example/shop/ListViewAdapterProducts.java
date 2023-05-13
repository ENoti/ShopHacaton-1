package com.example.shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapterProducts extends ArrayAdapter<Product>{
        int listLayout;
        ArrayList<Product> usersList;
        Context context;

        public ListViewAdapterProducts(Context context, int listLayout,
                                       int field, ArrayList<Product> usersList) {
            super(context, listLayout, field, usersList);
            this.context = context;
            this.listLayout=listLayout;
            this.usersList = usersList;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View listViewItem = inflater.inflate(listLayout, null, false);
            TextView name = listViewItem.findViewById(R.id.textName);
            TextView category = listViewItem.findViewById(R.id.textCategory);
            TextView amount = listViewItem.findViewById(R.id.textAmount);
            TextView price = listViewItem.findViewById(R.id.textPrice);
            name.setText(usersList.get(position).getName());
            category.setText(usersList.get(position).getCategory());
            amount.setText(usersList.get(position).getAmount() + "");
            price.setText(usersList.get(position).getPrice() + "");
            return listViewItem;
        }

}
