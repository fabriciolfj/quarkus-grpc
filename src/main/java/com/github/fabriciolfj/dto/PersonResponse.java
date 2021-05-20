package com.github.fabriciolfj.dto;

public class PersonResponse {

    private String name;
    private Integer document;

    public PersonResponse(String name, Integer document) {
        this.name = name;
        this.document = document;
    }

    public PersonResponse() {
        this.name = "unknown";
        this.document = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "PersonResponse{" +
                "name='" + name + '\'' +
                ", document=" + document +
                '}';
    }
}
