package com.gmail.ericarnou68.screenMatch.model;

public enum Category {
    COMEDIA ("Comedy", "Comédia"),
    DRAMA ("Drama" , "Drama"),
    ACAO ("Action", "Ação"),
    CRIME ("Crime", "Crime"),
    ROMANCE("Romance", "Romance");

    private String categoryOmdb;
    private String categoryOmdbPortugues;

    Category(String categoryOmdb, String categoryOmdbPortugues) {
        this.categoryOmdb = categoryOmdb;
        this.categoryOmdbPortugues = categoryOmdbPortugues;
    }

    public static Category fromString(String text) {
        for (Category category : Category.values()) {
            if (category.categoryOmdb.equalsIgnoreCase(text)){
                return category;
            }
        }
        throw new IllegalArgumentException("No categories found");
    }

    public static Category fromPortugues(String text) {
        for (Category category : Category.values()) {
            if (category.categoryOmdbPortugues.equalsIgnoreCase(text)){
                return category;
            }
        }
        throw new IllegalArgumentException("No categories found");
    }
}
