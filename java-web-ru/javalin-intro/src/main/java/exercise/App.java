package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {
        return Javalin.create(/*config*/)
                .get("/welcome", ctx -> ctx.result("Welcome to Hexlet!"));
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
