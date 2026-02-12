package br.com.alura.sreenmatch.models;

import br.com.alura.screematch.calculos.Classificavel;
import com.google.gson.annotations.SerializedName;

public class Filme extends Titulo implements Classificavel {
    @SerializedName("Director")
    private String diretor;
    private int duracaoMinutos;

    public Filme(){}

    public Filme(String nome, int anoLancamento,  int duracaoMinutos, boolean incluidoNoPlano, String diretor){
        super(nome, anoLancamento, duracaoMinutos, incluidoNoPlano);
        this.duracaoMinutos = duracaoMinutos;
        this.diretor = diretor;
    }

    /*public Filme(TituloOmbd t){
        super(t);
        this.duracaoMinutos = Integer.valueOf(t.runtime().substring(0,2));
    }*/

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public String toString() {
        return  "\nTítulo: "+getNome()
                +" ("+getAnoLancamento()+")"
                +"\nDuração: "+duracaoMinutos
                +" minutos"
                +"\nDiretor: "+diretor
                +String.format("\nMédia de avaliações: %.2f",calculaMedia());
    }

    @Override
    public int getClassificacao(){
        return (int) calculaMedia()/2;
    }
}