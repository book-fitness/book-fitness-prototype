package webservice;

import ru.tiger.bookprototype.entity.User;

/**
 *
 * @author Igor
 */
public class CreateCommentRequest {

    private User author;

    private String text;

    public CreateCommentRequest() {
    }

    public CreateCommentRequest(User author, String text) {
        this.author = author;
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
