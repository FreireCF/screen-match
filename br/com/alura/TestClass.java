package br.com.alura;

import br.com.alura.sreenmatch.models.*;
import br.com.alura.screematch.calculos.*;

import java.util.*;

public class TestClass {
    public static void main(String[] args) {
        List <Title> list = new LinkedList<>();
        var filter = new recommendationFilter();

        var movie = new Movie("Forrest Gump", 1994, 142, true, "Robert Zemeckis");
        list.add(movie);
        movie.review(10);
        movie.review(9.35);
        movie.review(9.8);

        var movie1 = new Movie("O Poderoso Chefão", 1972, 179, true, "Francis F. Coppola");
        list.add(movie1);
        movie1.review(9.8);
        movie1.review(9.9);
        movie1.review(9.9);

        var got = new tvShow("Game of Thrones", 2011, true, 8, 73, false);
        list.add(got);
        got.review(9.2);
        got.review(8.9);
        got.review(9.1);

        var bb = new tvShow("Breaking Bad", 2008, true, 5, 62, false);
        list.add(bb);
        bb.review(10);
        bb.review(9.7);
        bb.review(9.8);

        var ep1 = new Episode("Winter is Coming", 1, 1, 62, got);
        //System.out.println(got.getNome());
        ep1.review(9);
        ep1.review(8.9);
        ep1.review(8.7);
        got.addEpisode(ep1);

        var ep1Bb = new Episode("Pilot", 1, 1, 58, bb);
        bb.addEpisode(ep1Bb);
        ep1Bb.review(9.4);
        ep1Bb.review(9.0);
        ep1Bb.review(8.9);

        Collections.sort(list); //ordenar por ordem alfabética (título)
        //lista.sort(Comparator.comparing(Titulo::getAnoLancamento)); //ordenar pelo ano de lançamento

        System.out.println("\nLista de filmes e séries: ");
        for (Title t: list){
            if (t instanceof Movie){ //instanceof: verifica o tipo do objeto. Printa somente se o tipo do Titulo t é um Filme
                System.out.println(t);
            }
        }

        System.out.println("\nLista de séries: ");
        for (Title t: list){
            if (t instanceof tvShow){
                System.out.println(t);
            }
        }
    }
}