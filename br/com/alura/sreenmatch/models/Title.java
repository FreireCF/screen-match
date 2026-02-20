package br.com.alura.sreenmatch.models;

import br.com.alura.screenmatch.exceptions.ErroConversaoDeAnoException;

public class Title implements Comparable<Title>{
    //@SerializedName("Title") //não é recomendado, pouquíssima flexibilidade
    private String name;

    //@SerializedName("Year")
    private int year;
    private int runtime;
    private boolean isInPlan;
    private double sumReviews;
    private int totalReviews;

    public Title(){}

    public Title(String name, int year, int runtime, boolean isInPlan){
        this.name = name;
        this.year = year;
        this.runtime = runtime;
        this.isInPlan = isInPlan;
    }

    public Title(String name, int runtime, boolean isInPlan){
        this.name = name;
        this.runtime = runtime;
        this.isInPlan = isInPlan;
    }

    public Title(TitleOmbd t) {
        this.name = t.title();
        if (t.year().length() > 4) {
            throw new ErroConversaoDeAnoException("Não converteu o ano porque tem mais de 4 caracteres");
        }
            this.year = Integer.valueOf(t.year()); //converter String year para int anoLancamento
            this.runtime = Integer.valueOf(t.runtime().substring(0, 3));
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getRuntime(){
        return runtime;
    }

    public boolean isInPlan() {
        return isInPlan;
    }

    public double getSumReviews() {
        return sumReviews;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setInPlan(boolean inPlan) {
        this.isInPlan = inPlan;
    }

    public void setSumReviews(double sumReviews) {
        this.sumReviews = sumReviews;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }

    public void review(double note){
        this.sumReviews +=note;
        this.totalReviews++;
    }

    public double calculateReview(){
        return sumReviews / totalReviews;
    }

    @Override
    public String toString() {
        return "\nNome: "+this.name
                +" ("+this.year +")"
                +"\nDuração: " +this.runtime
                +" min";
                //+"\nDiretor: ";
                //+"\nMédia das avaliações: "+calculaMedia();
    }

    @Override
    public int compareTo(Title t){ //ordem alfabética dos títulos
        return this.getName().compareTo(t.getName());
    }
}