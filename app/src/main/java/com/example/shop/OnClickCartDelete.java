package com.example.shop;

import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class OnClickCartDelete implements View.OnClickListener {
    private Product product;
    private int shop_id;
    private RequestQueue requestQueue;

    private CartWindow cartWindow;
    private Cart cart;

    public OnClickCartDelete(Product product, int shop_id, RequestQueue requestQueue, CartWindow cartWindow, Cart cart) {
        this.product = product;
        this.shop_id = shop_id;
        this.requestQueue = requestQueue;
        this.cartWindow = cartWindow;
        this.cart = cart;
    }

    @Override
    public void onClick(View v) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", product.getId());
            jsonObject.put("name",product.getName());
            jsonObject.put("category",product.getCategory());
            jsonObject.put("amount",product.getAmount());
            jsonObject.put("price",product.getPrice());
            String requestBody = jsonObject.toString();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://aff3-194-186-53-99.ngrok-free.app/api/shops/" + shop_id + "/products",
                    response -> Toast.makeText(cartWindow, "Success", Toast.LENGTH_SHORT).show(),
                    error -> Toast.makeText(cartWindow, "Error", Toast.LENGTH_SHORT).show()) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }
                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }
                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {
                        responseString = String.valueOf(response.statusCode);
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };

            requestQueue.add(stringRequest);
            cart.deleteProduct(product);
            cartWindow.loadProductsFromCart();
        }  catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
