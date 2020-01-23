package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    private  RecyclerView mRecyclerview;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    ArrayList<HashMap<String, String>> arrayListNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerview =  findViewById(R.id.mRecyclerview);
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerview.setLayoutManager(mLayoutManager);

        callAPI();

    }
    private void callAPI() {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        //String url = "https://api.myjson.com/bins/1eits2";
        String url = "https://api.myjson.com/bins/w3hge";
        //String url = "https://chandansatyendraprasad.000webhostapp.com/tests";
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("=====", "=========response:" + response);
                        parseAPIResponse(response);
                    }

                    private void parseAPIResponse(String response) {
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mTextView.setText("That didn't work!");
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }


}
