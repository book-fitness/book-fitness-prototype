package ru.tiger.bookprototype.webservice;

/**
 *
 * @author Igor
 */
class CreateArticleRequest {

    private String header;
    private String content;

    public CreateArticleRequest(String header, String content) {
        this.header = header;
        this.content = content;
    }

    public CreateArticleRequest() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
