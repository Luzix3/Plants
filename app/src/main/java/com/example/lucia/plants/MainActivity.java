package com.example.lucia.plants;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String EXTRA_ANIMALE= "animale";
    private final static String url="http://192.168.1.3/getSensori.php";

    //listview object
    ListView listView;

    private Adapter adapter;

    //the hero list where we will store all the hero objects after parsing json
    List<Animale> Animalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing listview and hero list
        listView = findViewById(R.id.listView);
        Animalist = new ArrayList<>();

        //creating custom adapter object
        adapter = new Adapter(Animalist, getApplicationContext());

        //adding the adapter to listview
        listView.setAdapter(adapter);

        //this method will fetch and parse the data
        loadAnimaList();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Animale animale = adapter.getItem(position);
                Intent intent = new Intent(view.getContext(), Stato.class);
                startActivity(intent);
            }
        });


    }

    private void loadAnimaList() {

        //creating a string request to send request to the url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //getting the whole json object from the response
                            JSONObject obj = new JSONObject(response);

                            //we have the array named hero inside the object
                            //so here we are getting that json array
                            JSONArray animaArray = obj.getJSONArray("Animali");

                            //now looping through all the elements of the json array
                            for (int i = 0; i < animaArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject animaliobj = animaArray.getJSONObject(i);

                                //creating a hero object and giving them the values from json object
                                Animale animals= new Animale(animaliobj.getString("Name"));


                                //adding the hero to herolist
                                Animalist.add(animals);
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //adding the string request to request queue
        requestQueue.add(stringRequest);
    }








}
