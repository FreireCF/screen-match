package br.com.alura.sreenmatch.models;

import br.com.alura.screematch.calculos.Classifiable;
import com.google.gson.annotations.SerializedName;

public class Movie extends Title implements Classifiable {
    @SerializedName("Director") //ajeitar e criar um construtor recebendo (titleOmdb)
    private String director;

    public Movie(){}

    public Movie(String name, int year, int runtime, boolean isInPlan, String director){
        super(name, year, runtime, isInPlan);
        this.director = director;
    }

    /*public Filme(TituloOmbd t){
        super(t);
        this.duracaoMinutos = Integer.valueOf(t.runtime().substring(0,2));
    }*/

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return  "\nTítulo: "+ getName()
                +" ("+ getYear()+")"
                +"\nDuração: "+getRuntime()
                +" minutos"
                +"\nDiretor: "+ director
                +String.format("\nMédia de avaliações: %.2f", calculateReview());
    }

    @Override
    public int getReview(){
        return (int) calculateReview()/2;
    }
}