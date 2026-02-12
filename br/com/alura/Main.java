package br.com.alura;

import br.com.alura.sreenmatch.models.Titulo;
import br.com.alura.sreenmatch.models.TituloOmbd;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            var scanner = new Scanner(System.in);

            System.out.println("\nFilme para busca: ");
            var filme = scanner.nextLine();

            //var apiKey = "sua chave de api aqui"
            var apiKey = System.getenv("API_KEY_SCREEN_MATCH");
            var endereco = "http://www.omdbapi.com/?t=" + filme + "&apikey=" +apiKey;

            HttpClient client = HttpClient.newHttpClient(); //iniciliza o HttpClient (faz a requisição)
            HttpRequest request = HttpRequest.newBuilder() //construtor para uma Classe muito complexa
                    .uri(URI.create(endereco))
                    .build();

            //client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            //.thenApply(HttpResponse::body)
            //.thenAccept(System.out::println)
            //.join();

            HttpResponse<String> response = client //recebe a resposta da requisição
                    .send(request, HttpResponse.BodyHandlers.ofString());

            var json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            var f = gson.fromJson(json, TituloOmbd.class); //usado apenas para carregar os dados

            var t = new Titulo(f); //conversão de tipo de objeto

            //System.out.println("\nTítulo: "+f.getNome() + " (" + f.getAnoLancamento()+ ")");
            //System.out.println("\nDiretor: "+f.getDiretor());

            //System.out.println(f);
            System.out.println("\nApós conversão");
            System.out.println(t);


        }
    }
}