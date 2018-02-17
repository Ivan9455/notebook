package sample.object;

public class Ftext {
    private String path;
    private String text;

    public String getPath() {
        return path;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Ftext() {
    }

    public Ftext(String text) {
        this.text = text;
    }
}
