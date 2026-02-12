package br.com.alura;

import br.com.alura.sreenmatch.models.*;
import br.com.alura.screematch.calculos.*;

import java.util.*;

public class ListaTitulos {
    public static void main(String[] args) {
        List<Titulo> lista = new LinkedList<>();
        var filtro = new FiltroRecomendacao();

        var filme = new Filme("Forrest Gump", 1994, 142, true, "Robert Zemeckis");
        lista.add(filme);
        filme.avalia(10);
        filme.avalia(9.35);
        filme.avalia(9.8);

        var outroFilme = new Filme("O Poderoso Chefão", 1972, 179, true, "Francis F. Coppola");
        lista.add(outroFilme);
        outroFilme.avalia(9.8);
        outroFilme.avalia(9.9);
        outroFilme.avalia(9.9);

        var got = new Serie("Game of Thrones", 2011, true, 8, 73, false);
        lista.add(got);
        got.avalia(9.2);
        got.avalia(8.9);
        got.avalia(9.1);

        var bb = new Serie("Breaking Bad", 2008, true, 5, 62, false);
        lista.add(bb);
        bb.avalia(10);
        bb.avalia(9.7);
        bb.avalia(9.8);

        var ep1 = new Epsodio("Winter is Coming", 1, 1, 62, got);
        //System.out.println(got.getNome());
        ep1.avalia(9);
        ep1.avalia(8.9);
        ep1.avalia(8.7);
        got.addEpisodio(ep1);

        var ep1Bb = new Epsodio("Pilot", 1, 1, 58, bb);
        bb.addEpisodio(ep1Bb);
        ep1Bb.avalia(9.4);
        ep1Bb.avalia(9.0);
        ep1Bb.avalia(8.9);

        Collections.sort(lista); //ordenar por ordem alfabética (título)
        //lista.sort(Comparator.comparing(Titulo::getAnoLancamento)); //ordenar pelo ano de lançamento

        System.out.println("\nLista de filmes: ");
        for (Titulo t: lista){
            if (t instanceof Filme){ //instanceof: verifica o tipo do objeto. Printa somente se o tipo do Titulo t é um Filme
                System.out.println(t);
            }
        }

        System.out.println("\nLista de séries: ");
        for (Titulo t: lista){
            if (t instanceof Serie){
                System.out.println(t);
            }
        }
    }
}