package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    public static Map<String, Integer> getMinMax(int[] numbers) {
        LOGGER.setLevel(Level.INFO);
        Map<String, Integer> map = new HashMap<>();
        MaxThread thread = new MaxThread(numbers);
        MinThread thread1 = new MinThread(numbers);
        thread1.start();
        thread.start();
        try {
            thread1.join();
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        map.put("min", thread1.getMin());
        map.put("max", thread.getMax());
        return map;
    }
}
