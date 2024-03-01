package com.test;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
public class Main {
    private static  List<Book> LIST;
    public static void main(String[] args) throws InterruptedException {
        System.out.print("H");
        Thread.sleep(1000);
        System.out.print("e");
        Thread.sleep(1000);
        System.out.print("l");
        Thread.sleep(1000);
        System.out.print("l");
        Thread.sleep(1000);
        System.out.print("o");
        Thread.sleep(1000);

        Thread tt = new Thread() {
            public void run() {
                System.out.println("线程开始运行");
                Thread.currentThread().suspend();
                System.out.println("线程继续运行");
            }
        };

        tt.start();
        try {
            Thread.sleep(3000);
            tt.resume();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }


        Thread t = new Thread() {
            public void run() {
                while(true) {
                    if(Thread.currentThread().isInterrupted()) {
                        System.out.println("我被标记了!，卢本伟救我");
                        break;
                    }
                }
                Thread.interrupted(); //复原interrupt
                while(true) {
                    if(Thread.currentThread().isInterrupted()) {
                        System.out.println("我被标记了!，卢本伟救我");
                        break;
                    }
                }
                System.out.println("我是结束后的操作");
            }
        };
        t.start();
        try {
            Thread.sleep(3000);
            t.interrupt();
            Thread.sleep(3000);
            t.interrupt();
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    System.out.println("我是线程1 " + i);
                    Thread thread = Thread.currentThread();
                    System.out.println(thread.getName());
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    System.out.println("我是线程2 " + i);
                    Thread thread = Thread.currentThread();
                    System.out.println(thread.getName());
                    if(i == 10) throw new RuntimeException();
                    if(i == 80) {
                        Thread.currentThread().stop();
                    }
                }
            }
        };
        t1.start();
        t2.start();

        System.out.println("Loading...");
        load();
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
                case 2:
                    list();
                    break;
                case 3:
                    delete(scanner);
                    break;
                case 4:
                    modify(scanner);
                    break;
                case 5:
                    System.out.println("Saving...");
                    save();
                    System.out.println("bye");
                    return;
            }
        }
    }
    //加载之前存储的图书信息
    @SuppressWarnings("unchecked")
    private static void load() {
        File file = new File("data");
        if(file.exists()) {
            try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream("data"))) {
                LIST = (List<Book>) stream.readObject();
            }catch(IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            LIST = new LinkedList<>();
        }

    }
    //保存文件，持久化
    private static void save() {
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("data"))) {
            stream.writeObject(LIST);
            stream.flush();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    //添加文件
    private static void insert(Scanner scanner) {
        scanner.nextLine();
        System.out.print("please input the book's name:");
        String title = scanner.nextLine();
        System.out.print("please input the author of the book:");
        String author = scanner.nextLine();
        System.out.print("please input the price of the book:");
        Integer price = scanner.nextInt();
        Book book = new Book(title,author,price);
        LIST.add(book);

        System.out.println("添加成功！" + book);
    }
    //查询书籍
    private static void list() {
        for(int i = 0;i<LIST.size(); i ++) {
            System.out.println(i + "."+ LIST.get(i));
        }
    }

    //删除书籍（根据书单号来查询）
    private static void delete(Scanner scanner) {
        System.out.print("please input the delete book's id what you want:");
        scanner.nextLine();
        int index = scanner.nextInt();
        scanner.nextLine();
        while(index > LIST.size() - 1 || index < 0) {
            System.out.println("没有对应的书籍，请重新输入!");
            index = scanner.nextInt();
        }
        LIST.remove(index);
        System.out.println("删除书籍信息成功!");
    }
    private static void modify(Scanner scanner) {
        System.out.print("please input the modify book's id what you want:");
        scanner.nextLine();
        int index = scanner.nextInt();
        scanner.nextLine();
        while(index > LIST.size() - 1 || index < 0) {
            System.out.println("没有对应的书籍，请重新输入!");
            index = scanner.nextInt();
        }
        Book book = LIST.get(index);
        System.out.print("please input the book's title:");
        book.setTitle(scanner.nextLine());
        System.out.print("please input the book's author:");
        book.setAuthor(scanner.nextLine());
        System.out.print("please input the book's price:");
        book.setPrice(scanner.nextInt());
        scanner.nextLine();
        System.out.println("书籍信息修改成功!");
    }

}
