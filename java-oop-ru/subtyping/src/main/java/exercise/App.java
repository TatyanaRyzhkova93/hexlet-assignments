package exercise;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class App {
    public static void swapKeyValue(KeyValueStorage map) {
        Set<Map.Entry<String, String>> entrySet = map.toMap().entrySet();
        KeyValueStorage answer = new InMemoryKV(Map.of());
        for (Map.Entry<String, String> i : entrySet) {
            answer.set(i.getValue(), i.getKey());
        }
        for(Iterator<Entry<String, String>> it = map.toMap().entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, String> entry = it.next();
            map.unset(entry.getKey());
        }
        Set<Map.Entry<String, String>> entrySet2 = answer.toMap().entrySet();
        for (Map.Entry<String, String> i : entrySet2) {
            map.set(i.getKey(), i.getValue());
        }
    }
}
