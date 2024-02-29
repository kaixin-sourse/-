package com.test;
import java.util.Scanner;
public class Book {
    private String title;
    private String author;
    private int price;

    private Book(String title,String author,int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public static BookBuilder builder() {
        return new BookBuilder();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
    //建造者模式
    public static class BookBuilder{
        private String title;
        private String author;
        private int price;

        private BookBuilder(){}

        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }
        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }
        public BookBuilder price(int price) {
            this.price = price;
            return this;
        }
        public Book build() {
            return new Book(title,author,price);
        }

    }


}
