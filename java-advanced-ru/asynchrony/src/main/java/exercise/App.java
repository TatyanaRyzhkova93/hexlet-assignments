package exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;


class App {

    public static synchronized CompletableFuture<String> unionFiles(String file1, String file2, String dest) {
        CompletableFuture<String> readFile1 = CompletableFuture.supplyAsync(() -> {
            try {
                return readFile(file1);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<String> readFile2 = CompletableFuture.supplyAsync(() -> {
            try {
                return readFile(file2);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        Path path = Paths.get(dest);

        return readFile1.thenCombine(readFile2, (file1Data, file2Data) -> {
            System.out.println("file1Data " + file1Data);
            System.out.println("file2Data " + file2Data);
            try {
                Files.write(path, file1Data.concat(file2Data).getBytes(), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return file1Data.concat(file2Data);
        }).exceptionally(ex -> {
            System.out.println("NoSuchFileException - " + ex.getMessage());
            return null;
        });
    }

    private static String readFile(String filename) throws FileNotFoundException {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            StringBuilder data = new StringBuilder();
            while (myReader.hasNextLine()) {
                data.append(myReader.nextLine());
            }
            myReader.close();
            return data.toString();
    }

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> result = App.unionFiles("src/main/resources/file1.txt", "src/main/resources/file2.txt", "src/main/resources/dest.txt");
        System.out.println(result.get());
    }


}

