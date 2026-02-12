package br.com.alura.screematch.calculos;

public class recommendationFilter {

    public void filter(Classifiable c){
        if(c.getReview()>=4){
            System.out.println("Está entre os preferidos");
        } else if (c.getReview()>=2){
            System.out.println("Bem avaliado no momento");
        } else {
            System.out.println("Não é a melhor indicação no momento");
        }
    }

}
