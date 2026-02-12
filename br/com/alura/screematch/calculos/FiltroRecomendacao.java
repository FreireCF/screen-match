package br.com.alura.screematch.calculos;

import br.com.alura.sreenmatch.models.Titulo;

public class FiltroRecomendacao {

    public void filtra(Classificavel c){
        if(c.getClassificacao()>=4){
            System.out.println("Está entre os preferidos");
        } else if (c.getClassificacao()>=2){
            System.out.println("Bem avaliado no momento");
        } else {
            System.out.println("Não é a melhor indicação no momento");
        }
    }

}
