/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

/**
 *
 * @author Igor
 */
class UpdateBookRequest {

    private Long Id;
    private String name;
    private String publisher;
    private String annotation;
    private String coverPath;

    public UpdateBookRequest() {
    }

    public UpdateBookRequest(Long Id, String name, String publisher, String annotation, String coverPath) {
        this.Id = Id;
        this.name = name;
        this.publisher = publisher;
        this.annotation = annotation;
        this.coverPath = coverPath;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
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
