package com.example.lucia.plants;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Lucia on 26/02/2018.
 */

public class Adapter extends BaseAdapter{

    private List<Animale> animali = Collections.emptyList();
    private Context context;
    private ArrayList<Animale> animalis;
    LayoutInflater inflater;


    public Adapter (Context context, List<Animale> libri)
    {
        this.context = context;
        this.animali = animali;
        inflater = LayoutInflater.from(context);
        this.animalis = new ArrayList<Animale>();
        this.animalis.addAll(libri);
    }


    public class ViewHolder {
        TextView name;

    }

    public void update(List<Animale> newList)
    {
        animali = newList;
        notifyDataSetChanged();
    }

    //la listview chiederà all'adapter qunti elementi deve visualizzare
    @Override
    public int getCount() {
        return animali.size();
    }

    //
    @Override
    public Animale getItem(int position) {
        return animali.get(position);
    }

    //
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.activity_riga, null);
            holder.name = convertView.findViewById(R.id.textAnima);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(animali.get(position).getNome());


        ImageView ImageCopertina = convertView.findViewById(R.id.imageAnimale);

        //metto i parametri nell'oggetto libro per poi farli comparire nella listview
        Animale animale = animali.get(position);

        //carico immagine dal metodo creato prima attraverso url
        //uso picasso che è una libreria trovata su github, essenzialmente carica, dato un context, un url in una immagine
        //gestisce si amemoria che cache
        //   Picasso.with(context).load(libro.getUrlimmagine()).fit().into(ImageCopertina);

        return convertView;
    }
    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

}
