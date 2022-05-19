package com.gdelgado.api.resource;

public class MoviesRequest {

    private String name;

    private int ranking;

    private String comments;

    public MoviesRequest() {
    }

    public MoviesRequest(String name, int ranking, String comments) {
        this.name = name;
        this.ranking = ranking;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
