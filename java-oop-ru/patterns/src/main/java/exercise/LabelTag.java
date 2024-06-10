package exercise;

class LabelTag implements TagInterface {
    private String text;
    private TagInterface tag;
    public LabelTag(String text, TagInterface tag) {
        this.tag = tag;
        this.text = text;
    }
    @Override
    public String render() {
        return "<label>" + text + tag.render() +"</label>";
    }
}
