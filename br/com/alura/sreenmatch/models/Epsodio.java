package br.com.alura.sreenmatch.models;

import br.com.alura.screematch.calculos.*;

public class Epsodio extends Titulo implements Classificavel {
    private String nome;
    private int numero;
    private int temporada;
    private double duracaoMin;
    private Serie serie;

    public Epsodio() {
    }

    public Epsodio(String nome, int numero, int temporada, double duracaoMin, Serie serie) {
        this.nome = nome;
        this.numero = numero;
        this.temporada = temporada;
        this.duracaoMin = duracaoMin;
        this.serie = serie;
    }

    public String getNome() {
        return this.nome;
    }

    public int getNumero() {
        return this.numero;
    }

    public double getDuracaoMin() {
        return this.duracaoMin;
    }

    public int getTemporada(){
        return this.temporada;
    }

    public Serie getSerie() {
        return this.serie;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDuracaoMin(double duracaoMin) {
        this.duracaoMin = duracaoMin;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getClassificacao() {
        return (int) calculaMedia()/2;
    }

    @Override
    public String toString(){
        return "\nNome: "+this.nome
                +"Número: "+this.numero
                +"\nTemporada: "+this.temporada
                +"\nDuração: "+this.duracaoMin
                +" minutos";
    }
}
