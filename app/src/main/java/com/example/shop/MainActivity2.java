package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private static String JSON_URL = "https://914e-195-225-110-33.ngrok-free.app/api/shops/";// UTF-8

    int shop_id;
    ListView listView;
    Shop shop;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        shop_id = intent.getIntExtra("shop_id",0);
        System.out.println(shop_id);
        setContentView(R.layout.activity_main2);
        listView = (ListView) findViewById(R.id.listView);
        btn1 = (Button) findViewById(R.id.buttonProducts);
        btn1.setOnClickListener(this);
        loadJSONFromURL(JSON_URL + shop_id);
    }

    private void  loadJSONFromURL(String url){
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(ListView.VISIBLE);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.INVISIBLE);
                        try {
                            JSONArray object = new JSONArray(EncodingToUTF8(response));
                            ArrayList<Product> listItems = new ArrayList<>();
                            for (JSONObject o: getArrayListFromJSONArray(object)){
                                Product product = new Product(o.getInt("id"),
                                        o.getString("name"), o.getString("category"),
                                        o.getInt("amount"), o.getInt("price"));
                                listItems.add(product);
                            }
                            ListAdapter adapter = new ListViewAdapterProducts(getApplicationContext(),
                                    R.layout.shop,R.id.textViewName,listItems);
                            listView.setAdapter(adapter);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private ArrayList< JSONObject> getArrayListFromJSONArray(JSONArray jsonArray){
        ArrayList< JSONObject> aList = new ArrayList<JSONObject>();
        try {
            if(jsonArray!= null){
                for(int i = 0; i< jsonArray.length();i++){
                    aList.add(jsonArray.getJSONObject(i));
                }
            }
        }catch (JSONException js){
            js.printStackTrace();
        }
        return aList;
    }
    public  static  String EncodingToUTF8(String response){
        try {
            byte[] code = response.toString().getBytes("ISO-8859-1");
            response = new String(code, "UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
            return null;
        }
        return response;
    }
    @Override
    public void onClick(View v) {
        loadJSONFromURL(JSON_URL + shop_id);
    }
}