package webservice;

/**
 *
 * @author Igor
 */
public class CreateCommentRequest {

    private String text;
    private Long parentId;
    private Long articleId;

    public CreateCommentRequest() {
    }

    public CreateCommentRequest(String text, Long parentId, Long articleId) {
        this.text = text;
        this.parentId = parentId;
        this.articleId = articleId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}
