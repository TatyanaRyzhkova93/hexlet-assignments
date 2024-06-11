package exercise;

import java.util.stream.Collectors;
import java.util.Map;

abstract class Tag {
    protected String name;
    protected Map<String, String> attributes;
    private String attrToString() {
        return attributes.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(" "));
    }
    protected String getFirstTag() {
        return !attributes.isEmpty() ? "<" + name + " " + attrToString() + ">"
                : "<" + name + ">";
    }

    public abstract String toString();

    protected Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    protected String getName() {
        return name;
    }
}