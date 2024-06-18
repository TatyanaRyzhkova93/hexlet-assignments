package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        ObjectMapper objectMapper = new ObjectMapper();

        app.get("/users", ctx -> {
            var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
            var start = page * (per) - per;
            List<Map<String, String>> users = new ArrayList<>();
            for (int i = start; i < start + per; i++) {
                users.add(USERS.get(i));
            }
            try {
                ctx.json(objectMapper.writeValueAsString(users));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
