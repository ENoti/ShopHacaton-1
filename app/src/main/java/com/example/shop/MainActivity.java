package com.example.shop;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String JSON_URL_SHOP = "https://d5b4-194-186-53-99.ngrok-free.app/api/shops";// UTF-8
    ListView listView;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        btn1 = (Button) findViewById(R.id.button);
        btn1.setOnClickListener(this);
        loadJSONFromURL(JSON_URL_SHOP);
    }

    private void  loadJSONFromURL(String url){
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(ListView.VISIBLE);
        MainActivity mainActivity = this;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.INVISIBLE);
                        try {
                            JSONArray object = new JSONArray(EncodingToUTF8(response));
                            ArrayList<Shop> listItems = new ArrayList<>();
                            for (JSONObject o: getArrayListFromJSONArray(object)){
                                Shop shop = new Shop(o.getInt("id"),
                                        o.getString("name"), o.getString("address"));
                                listItems.add(shop);
                            }
                            ListAdapter adapter = new ListViewAdapter(getApplicationContext(),
                                    R.layout.row,R.id.textViewName,listItems,mainActivity);
                            listView.setAdapter(adapter);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
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
        loadJSONFromURL(JSON_URL_SHOP);
    }
}