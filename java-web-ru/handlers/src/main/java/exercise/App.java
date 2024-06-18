package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;

import java.util.List;

public final class App {

    public static Javalin getApp() {
        // Получаем список телефонов
        List<String> phones = Data.getPhones();
        // Получаем список доменных имен
        List<String> domains = Data.getDomains();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPhones, jsonDomains;
        try {
            jsonPhones = objectMapper.writeValueAsString(phones);
            jsonDomains = objectMapper.writeValueAsString(phones);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/phones", ctx -> ctx.result(jsonPhones));
        app.get("/domains", ctx -> ctx.result(jsonDomains));
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
