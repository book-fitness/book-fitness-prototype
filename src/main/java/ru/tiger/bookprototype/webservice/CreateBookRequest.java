package ru.tiger.bookprototype.webservice;

/**
 *
 * @author Igor
 */
class CreateBookRequest {

    private String name;
    private String publisher;
    private String annotation;
    private String coverPath;

    public CreateBookRequest() {
    }

    public CreateBookRequest(String name, String publisher, String annotation, String coverPath) {
        this.name = name;
        this.publisher = publisher;
        this.annotation = annotation;
        this.coverPath = coverPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }
}
