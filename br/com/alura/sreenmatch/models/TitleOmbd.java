package br.com.alura.sreenmatch.models;

public record TitleOmbd(String title, String year, String runtime) {

    @Override
    public String toString(){
        return  "\nTítulo: "+this.title
                +" (" +this.year+")"
                +"\nDuração: "+this.runtime
                +" min";
    }
}