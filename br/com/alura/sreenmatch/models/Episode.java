package br.com.alura.sreenmatch.models;

import br.com.alura.screematch.calculos.*;

public class Episode extends Title implements Classifiable {
    private String name;
    private int number;
    private int season;
    private int runtime;
    private tvShow serie;

    public Episode() {
    }

    public Episode(String name, int number, int season, int runtime, tvShow serie) {
        this.name = name;
        this.number = number;
        this.season = season;
        this.runtime = runtime;
        this.serie = serie;
    }

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.number;
    }

    public int getRuntime() {
        return this.runtime;
    }

    public int getSeason(){
        return this.season;
    }

    public tvShow getSerie() {
        return this.serie;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public void setSerie(tvShow serie) {
        this.serie = serie;
    }

    @Override
    public int getReview() {
        return (int) calculateReview()/2;
    }

    @Override
    public String toString(){
        return "\nNome: "+this.name
                +"Número: "+this.number
                +"\nTemporada: "+this.season
                +"\nDuração: "+this.runtime
                +" minutos";
    }
}