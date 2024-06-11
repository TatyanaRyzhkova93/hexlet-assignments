package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

class PairedTag extends Tag {
    private String text;
    private List<Tag> tags;

    public PairedTag(String name, Map<String, String> attributes, String text, List<Tag> tags) {
        super(name, attributes);
        this.text = text;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return super.getFirstTag() + text + getChild() + "</" + super.getName() + ">";
    }

    private String getChild() {
        StringBuilder answer = new StringBuilder("");
        for (Tag tag : tags) {
            answer.append(tag.getFirstTag());
        }
        return answer.toString();
    }
}
