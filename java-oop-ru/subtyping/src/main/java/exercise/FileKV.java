package exercise;

import java.util.HashMap;
import java.util.Map;

class FileKV implements KeyValueStorage{
    private String path;
    private Map<String, String> map;
    public FileKV(String path, Map<String, String> mapp) {
        this.path = path;
        map = new HashMap<>();
        map.putAll(mapp);
    }
    @Override
    public void set(String key, String value) {
        map.put(key, value);
    }

    @Override
    public void unset(String key) {
        map.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return map.containsKey(key) ? map.get(key) : defaultValue;
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(map);
    }
}
