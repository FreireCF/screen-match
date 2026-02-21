package br.com.alura;

import br.com.alura.screenmatch.exceptions.ErroConversaoDeAnoException;
import br.com.alura.sreenmatch.models.Title;
import br.com.alura.sreenmatch.models.TitleOmbd;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        var scanner = new Scanner(System.in);
        var apiKey = System.getenv("API_KEY_SCREEN_MATCH");
        var titleToSearch = "";

        List<Title> titles = new LinkedList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!titleToSearch.equalsIgnoreCase("sair")) {
            System.out.println("\nFilme para busca: ");
            titleToSearch = scanner.nextLine();

            if (titleToSearch.equalsIgnoreCase("sair")) {
                System.out.println("\nEncerrando aplicação...");
                break;
            }

            //var apiKey = "sua chave de api aqui"
            var adress = "http://www.omdbapi.com/?t=" + String.valueOf(titleToSearch.replace(" ", "+")) + "&apikey=" + apiKey;

            try {
                HttpClient client = HttpClient.newHttpClient(); //iniciliza o HttpClient (faz a requisição)
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(adress)).build(); //construtor para uma Classe muito complexa

                //client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                //.thenApply(HttpResponse::body)
                //.thenAccept(System.out::println)
                //.join();

                HttpResponse<String> response = client //recebe a resposta da requisição
                        .send(request, HttpResponse.BodyHandlers.ofString());

                var json = response.body();
                //System.out.println(json);

                var temp = gson.fromJson(json, TitleOmbd.class); //usado apenas para carregar os dados

                var title = new Title(temp); //conversão de tipo de objeto

                titles.add(title);
                System.out.println(title);
            } catch (NumberFormatException e) {
                System.out.println("\nErro encontrado: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("\nErro de argumento: " + e.getMessage());
            } catch (ErroConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
            //System.out.println("\nFinalizado corretamente");
        }
        System.out.println("\nFilmes encontrados com sucesso: \n");
        for (Title t : titles) {
            System.out.println(t.getName() + " (" + t.getYear() + ")");
        }

        var writer = new FileWriter("titulos.json");
        writer.write(gson.toJson(titles));
        writer.close();
    }
}