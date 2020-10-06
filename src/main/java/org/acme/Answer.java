package org.acme;

public class Answer {

    public int id;
    public String description;
    public int sentiment;

    public Answer() {
    }

    public Answer(int id, String description, int sentiment) {
        this.id = id;
        this.description = description;
        this.sentiment = sentiment;
    }
}