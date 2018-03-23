package com.example.lucia.plants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
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

import java.util.ArrayList;
import java.util.List;

public class Stato extends AppCompatActivity {
    //the URL having the json data
    private static final String URL = "http://192.168.1.5/getData.php/?ID_Sensore=1";

    List<Animale> animalest;

    TextView textAcqua2;
    TextView textTemp2;
    TextView textUmid2;
    TextView textData2;

    String LivAcqua;
    String Temp;
    String Umid;
    String ultData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stato);


            //initializing listview and hero list
            animalest = new ArrayList<>();

            textAcqua2= findViewById(R.id.textAcqua2);
            textTemp2= findViewById(R.id.textTemp2);
            textUmid2= findViewById(R.id.textUmidita2);
            textData2= findViewById(R.id.textData2);


        //this method will fetch and parse the data
            loadAnimalest();



        }

        private void loadAnimalest() {

            //creating a string request to send request to the url
            StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                //getting the whole json object from the response
                                JSONObject objj = new JSONObject(response);

                                //we have the array named hero inside the object
                                //so here we are getting that json array
                                JSONArray anmArray = objj.getJSONArray("data");

                                //now looping through all the elements of the json array
                                for (int i = 0; i < anmArray.length(); i++) {
                                    //getting the json object of the particular index inside the array
                                    JSONObject anmObject = anmArray.getJSONObject(i);

                                    //creating a hero object and giving them the values from json object
                                    Animale anm1= new Animale(anmObject.getInt("ID_Sensore"), anmObject.getInt("Livello_acqua"),
                                                                anmObject.getDouble("Temperatura"), anmObject.getDouble("Umidità"),
                                                                anmObject.getString("Data_evento"));

                                    LivAcqua=String.valueOf(anm1.getLivello_acqua());
                                    Temp = String.valueOf(anm1.getTemperatura());
                                    Umid= String.valueOf(anm1.getUmidità());
                                    ultData= anm1.getData_evento();

                                    textAcqua2.setText(LivAcqua.concat(" ml"));
                                    textTemp2.setText(Temp.concat(" °C"));
                                    textUmid2.setText(Umid.concat(" %"));
                                    textData2.setText(ultData);

                                    animalest.add(anm1);
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

