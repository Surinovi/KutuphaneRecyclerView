package com.gyk2017.kutuphanerecyclerview;

/**
 * Created by neval on 18/06/2017.
 */

public class Book {

    private String name;
    private String author;
    private String publishYear;
    private int coverImage;
    private String url;

    public Book(String name, String author, String publishYear, int coverImage, String url) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.coverImage = coverImage;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public int getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(int coverImage) {
        this.coverImage = coverImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
