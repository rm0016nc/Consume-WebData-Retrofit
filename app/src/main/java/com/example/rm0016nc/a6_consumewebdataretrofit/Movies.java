package com.example.rm0016nc.a6_consumewebdataretrofit;

public class Movies {
    private String title;
    private String description;
    private String director;

    public Movies(String title, String description, String director) {
        this.title = title;
        this.description = description;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
