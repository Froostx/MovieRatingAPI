package com.gdelgado.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Movies")
public class Movie {

    @Id
    private String id;

    private String name;

    private Double ranking;

    private String comments;

    public Movie() {
    }

    public Movie(String name, Double ranking, String comments) {
        this.name = name;
        this.ranking = ranking;
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRanking() {
        return ranking;
    }

    public void setRanking(Double ranking) {
        this.ranking = ranking;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
