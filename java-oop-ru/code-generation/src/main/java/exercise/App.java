package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

class App {
    public static void save(Path path, Car car) throws IOException {
        String str = Car.serialize(car);
        Files.write(path, str.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.WRITE);
    }
    public static Car extract(Path path) throws IOException {
        String str = Files.readString(path);
        return Car.unserialize(str);
    }
}
