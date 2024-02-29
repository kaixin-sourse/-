package com.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main {
    private static final List<Book> LIST = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {

            System.out.println("1.录入书籍信息");
            System.out.println("2.查阅书籍信息");
            System.out.println("3.删除书籍信息");
            System.out.println("4.修改书籍信息");
            System.out.println("5.推出系统");
            switch(scanner.nextInt()) {
                case 1:
                    insert(scanner);
                    break;
                case 5:
                    System.out.println("bye");
                    return;
            }
        }
    }
    private static void insert(Scanner scanner) {
        scanner.next();
        Book book = Book.builder()
                .title(scanner.nextLine())
                .author(scanner.nextLine())
                .price(scanner.nextInt())
                .build();
        scanner.next();
        LIST.add(book);

        System.out.println("添加成功！");
    }
}
