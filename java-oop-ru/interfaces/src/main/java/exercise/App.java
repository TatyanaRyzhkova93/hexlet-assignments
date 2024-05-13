package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class App {
    public static List<String> buildApartmentsList(List<Home> homes, int count) {
        return homes.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .limit(count)
                .map(Home::toString)
                .collect(Collectors.toList());
    }
}