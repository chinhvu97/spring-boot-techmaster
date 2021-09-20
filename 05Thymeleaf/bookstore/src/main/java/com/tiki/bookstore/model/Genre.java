package com.tiki.bookstore.model;

public enum Genre {
    NOVEL("Novel"),
    MAGAZINES("Magazines"),
    COMIC("Comic"),
    POEM("Poem");

    private String value;
    Genre(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
