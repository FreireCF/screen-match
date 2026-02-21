package br.com.alura;

import br.com.alura.screenmatch.exceptions.ErroConversaoDeAnoException;
import br.com.alura.sreenmatch.models.OmdbService;
import br.com.alura.sreenmatch.models.Title;
import br.com.alura.sreenmatch.models.TitleOmbd;
import br.com.alura.sreenmatch.models.Writer;
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
        List<Title> titles = new LinkedList<>();
        var apiResponse = new OmdbService();
        var scanner = new Scanner(System.in);
        var titleToSearch = "";

        while (!titleToSearch.equalsIgnoreCase("sair")) {
            System.out.println("\nFilme para busca: ");
            titleToSearch = scanner.nextLine();

            if (titleToSearch.equalsIgnoreCase("sair")) {
                System.out.println("\nEncerrando aplicação...");
                break;
            }

            try {
                var title = new Title(apiResponse.service(titleToSearch));
                titles.add(title);
                System.out.println(title);
            } catch (NumberFormatException e) {
                System.out.println("\nErro encontrado: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("\nErro de argumento: " + e.getMessage());
            } catch (ErroConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("\nFilmes encontrados: \n");
        for (Title t : titles) {
            System.out.println(t.getName() + " (" + t.getYear() + ")");
        }

        var writer = new Writer(titles);

    }
}