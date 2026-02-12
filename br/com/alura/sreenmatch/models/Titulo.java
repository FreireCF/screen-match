package br.com.alura.sreenmatch.models;

import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    //@SerializedName("Title") //não é recomendado, pouquíssima flexibilidade
    private String nome;

    //@SerializedName("Year")
    private int anoLancamento;
    private int duracaoMin;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes=0;
    private int totalDeAvaliacoes=0;

    public Titulo(){}

    public Titulo(String nome, int anoLancamento, int duracaoMin, boolean incluidoNoPlano){
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.duracaoMin = duracaoMin;
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public Titulo(String nome, int anoLancamento, boolean incluidoNoPlano){ //gambiarra de um construturo p SÉRIE. não é relevante no momento
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public Titulo(TituloOmbd t){
        this.nome = t.title();
        this.anoLancamento = Integer.valueOf(t.year()); //converter String year para int anoLancamento
        this.duracaoMin = Integer.valueOf(t.runtime().substring(0, 3));
    }

    public String getNome() {
        return nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public double getSomaDasAvaliacoes() {
        return somaDasAvaliacoes;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setSomaDasAvaliacoes(double somaDasAvaliacoes) {
        this.somaDasAvaliacoes = somaDasAvaliacoes;
    }

    public void setTotalDeAvaliacoes(int totalDeAvaliacoes) {
        this.totalDeAvaliacoes = totalDeAvaliacoes;
    }

    public void avalia(double nota){
        this.somaDasAvaliacoes+=nota;
        this.totalDeAvaliacoes++;
    }

    public double calculaMedia(){
        return somaDasAvaliacoes/totalDeAvaliacoes;
    }

    @Override
    public String toString() {
        return "\nNome: "+this.nome
                +" ("+this.anoLancamento +")"
                +"\nDuração: " +this.duracaoMin
                +" min";
                //+"\nDiretor: ";
                //+"\nMédia das avaliações: "+calculaMedia();
    }

    @Override
    public int compareTo(Titulo t){ //ordem alfabética dos títulos
        return this.getNome().compareTo(t.getNome());
    }
}