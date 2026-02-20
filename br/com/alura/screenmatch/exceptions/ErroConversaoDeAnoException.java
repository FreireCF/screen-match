package br.com.alura.screenmatch.exceptions;

public class ErroConversaoDeAnoException extends RuntimeException {
    private String mensagem;

    public ErroConversaoDeAnoException(String mensagem){
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage(){
        return this.mensagem;
    }
}