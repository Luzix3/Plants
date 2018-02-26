package com.example.lucia.plants;

/**
 * Created by Lucia on 26/02/2018.
 */

public class Animale {

    //attributi animale

    private int acqua;
    private String nome;
    private int cibo;
    private int temperatura;


//costruttore
    public Animale(String nome, int acqua, int cibo, int temperatura)
    {
        this.nome=nome;
        this.acqua=acqua;
        this.cibo=cibo;
        this.temperatura=temperatura;

    }
    //costruttore vuoto
    public Animale()
    {

    }

    //getters e setters
    public int getAcqua() {
        return acqua;
    }

    public void setAcqua(int acqua) {
        this.acqua = acqua;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCibo() {
        return cibo;
    }

    public void setCibo(int cibo) {
        this.cibo = cibo;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }




}
