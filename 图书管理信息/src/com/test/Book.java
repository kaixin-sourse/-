package com.test;
import java.io.Serializable;
import java.util.Scanner;
public class Book implements Serializable { //Book也要支持序列化
    private String title;
    private String author;
    private int price;

    public Book(String title,String author,int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
