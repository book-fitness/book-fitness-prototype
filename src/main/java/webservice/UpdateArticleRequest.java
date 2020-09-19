package webservice;

/**
 *
 * @author Igor
 */
public class UpdateArticleRequest {

    private Long id;
    private String headers;
    private String content;

    public UpdateArticleRequest() {
    }

    public UpdateArticleRequest(Long id, String headers, String content) {
        this.id = id;
        this.headers = headers;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
