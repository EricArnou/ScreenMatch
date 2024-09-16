package com.gmail.ericarnou68.screenMatch.model;

public enum Category {
    COMEDIA ("Comedy"),
    DRAMA ("Drama"),
    ACAO ("Action"),
    CRIME ("Crime"),
    ROMANCE("Romance");

    private String categoryOmdb;
    Category(String categoryOmdb) {
        this.categoryOmdb = categoryOmdb;
    }

    public static Category fromString(String text) {
        for (Category category : Category.values()) {
            if (category.categoryOmdb.equalsIgnoreCase(text)) {
                return category;
            }
        }
        throw new IllegalArgumentException("No categories found");
    }
}
