package br.com.alura.sreenmatch.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OmdbService {
    private final String apiKey = System.getenv("API_KEY");
    private Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public TitleOmbd service(String titleToSearch) throws IOException, InterruptedException{
        var adress = "http://www.omdbapi.com/?t=" + String.valueOf(titleToSearch.replace(" ", "+")) + "&apikey=" + apiKey;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(adress)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        var apiResponse = gson.fromJson(response.body(), TitleOmbd.class);

        return apiResponse;
    }

}
