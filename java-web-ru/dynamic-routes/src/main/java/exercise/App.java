package exercise;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/companies/{id}", ctx -> {
            var id = ctx.pathParamAsClass("id", String.class).getOrDefault("null");
            // Позже мы разберем эти конструкции подробнее


            var company = COMPANIES.stream()
                    .filter(lis -> lis.containsKey("id"))
                    .filter(lis -> lis.containsValue(id)).findAny()
                    .orElseThrow(() -> new NotFoundResponse("Company not found"));
            ctx.json(company);
        });

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
