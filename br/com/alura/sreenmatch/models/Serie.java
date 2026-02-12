package br.com.alura.sreenmatch.models;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Titulo{
    private int temporadas;
    private int totalEpsodios;
    private boolean emLancamento;
    private List<Epsodio> epsodios = new ArrayList<>();

    public Serie(){}

    public Serie(String nome, int anoLancamento, boolean incluidoNoPlano, int temporadas, int epsodios, boolean emLancamento){
        super(nome, anoLancamento, incluidoNoPlano);
        this.temporadas = temporadas;
        this.totalEpsodios = epsodios;
        this.emLancamento = emLancamento;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getTotalEpsodios() {
        return totalEpsodios;
    }

    public void setEpsPorTemp(int epsodios) {
        this.totalEpsodios = epsodios;
    }

    public boolean isEmLancamento() {
        return emLancamento;
    }

    public void setEmLancamento(boolean emLancamento) {
        this.emLancamento = emLancamento;
    }

    public void addEpisodio(Epsodio e) {
        epsodios.add(e);
    }


    @Override
    public String toString() {
        String resultado =
                "\nTítulo: "+getNome()
                +" ("+getAnoLancamento()+")"
                +"\nTemporadas: "+temporadas
                +"\nTotal de epsódios: "+ totalEpsodios
                +String.format("\nMédia de avaliações: %.2f",calculaMedia())
                +"\nSituação: ";

        resultado += emLancamento ? "em lançamento" : "finalizada";

        if(!epsodios.isEmpty() && epsodios!=null){
            resultado += "\nLista de epsódios: ";
            for (Epsodio e: epsodios){
                if(e.getSerie().getNome().equals(this.getNome())){
                    resultado += "\n- Temp: " + e.getTemporada()
                            + " Ep: " + e.getNumero()
                            + " - \"" + e.getNome()
                            +"\"";
                }
            }
        }

        return resultado;
    }
}
