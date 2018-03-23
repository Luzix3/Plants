package com.example.lucia.plants;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Lucia on 26/02/2018.
 */

public class Adapter extends ArrayAdapter<Animale>{

    private List<Animale> animali;
    private Context context;


    public Adapter(List<Animale> animali, Context context)
    {
        super(context,R.layout.activity_riga,animali);
        this.context=context;
        this.animali=animali;

    }

    //this method will return the list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getting the layoutinflater
        LayoutInflater inflater = LayoutInflater.from(context);

        //creating a view with our xml layout
        View listViewItem = inflater.inflate(R.layout.activity_riga, null, true);

        //getting text views
        TextView textAnima = listViewItem.findViewById(R.id.textAnima);


        //Getting the hero for the specified position
        Animale anm = animali.get(position);

        //setting hero values to textviews
       textAnima.setText(anm.getName());

        //returning the listitem
        return listViewItem;
    }
}
