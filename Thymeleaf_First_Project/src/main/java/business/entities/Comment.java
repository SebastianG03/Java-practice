package business.entities;

public class Comment {

    private Integer id = null;
    private String text = null;

    public Comment() {
        super();
    }

    public Comment(final Integer id, final String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }
}
