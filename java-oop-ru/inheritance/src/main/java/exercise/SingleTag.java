package exercise;

import java.util.Map;

class SingleTag extends Tag {
    @Override
    public String toString() {
        return super.getFirstTag();
    }

    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }
}