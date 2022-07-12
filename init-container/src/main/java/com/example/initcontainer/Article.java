package com.example.initcontainer;

public class Article {
    private final int id;
    private final String barcode;
    private final String description;

    public Article(int id, String barcode, String description) {
        this.id = id;
        this.barcode = barcode;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", barcode='" + barcode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
