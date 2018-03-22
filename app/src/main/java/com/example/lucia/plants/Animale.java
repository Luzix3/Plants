package com.example.lucia.plants;

/**
 * Created by Lucia on 26/02/2018.
 */

public class Animale {

    //attributi animale
    private int ID_Sensore;
    private int Livello_acqua;
    private String Name;
    private float Temperatura;
    private float Umidità;
    private String Data_evento;


//costruttore
    public Animale(String Name,int ID_Sensore, int Livello_acqua, float Temperatura, float Umidità, String Data_evento)
    {
       this.Name=Name;
       this.ID_Sensore=ID_Sensore;
       this.Livello_acqua=Livello_acqua;
       this.Temperatura=Temperatura;
       this.Umidità=Umidità;
       this.Data_evento=Data_evento;

    }
    //costruttore vuoto
    public Animale()
    {

    }
    public Animale(String Name)
    {
        this.Name=Name;
    }
    //getters e setters


    public int getID_Sensore() {
        return ID_Sensore;
    }

    public void setID_Sensore(int ID_Sensore) {
        this.ID_Sensore = ID_Sensore;
    }

    public int getLivello_acqua() {
        return Livello_acqua;
    }

    public void setLivello_acqua(int livello_acqua) {
        Livello_acqua = livello_acqua;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(float temperatura) {
        Temperatura = temperatura;
    }

    public float getUmidità() {
        return Umidità;
    }

    public void setUmidità(float umidità) {
        Umidità = umidità;
    }

    public String getData_evento() {
        return Data_evento;
    }

    public void setData_evento(String data_evento) {
        Data_evento = data_evento;
    }
}
