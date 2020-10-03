package ru.tiger.bookprototype.webservice;

/**
 *
 * @author Igor
 */
public class UpdateArticleRequest {

    private Long id;
    private String header;
    private String content;

    public UpdateArticleRequest() {
    }

    public UpdateArticleRequest(Long id, String header, String content) {
        this.id = id;
        this.header = header;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String headers) {
        this.header = headers;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
