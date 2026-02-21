package br.com.alura.sreenmatch.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {
    private Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public Writer(List<Title> titles) throws IOException {
        var writer = new FileWriter("titulos.json");
        writer.write(gson.toJson(titles));
        writer.close();
    }
}
