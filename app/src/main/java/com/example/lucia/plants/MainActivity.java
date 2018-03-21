package com.example.lucia.plants;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String EXTRA_ANIMALE= "animale";
    private final static String REMOTE_ADD= " ";



    private ListView listanimali=null;
    //private RequestQueue mRequestQueue=null;
    private ArrayAdapter<Animale> anadapter = null;

    private Adapter adapter;
    private List<Animale> animalilista = Collections.emptyList();
    ArrayList<Animale> arraylist = new ArrayList<Animale>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listanimali= findViewById(R.id.ListaAnimali);
        adapter = new Adapter(this,animalilista);

        listanimali.setAdapter(adapter);

        listanimali.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Animale animale = adapter.getItem(position);
                Intent intent = new Intent(view.getContext(), Stato.class);
            //    intent.putExtra(EXTRA_ANIMALE, animale);
                startActivity(intent);
            }
        });

        Animale animale1= new Animale();
        animale1.setNome("Animale 1");



    }
}
