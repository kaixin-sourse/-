package com.company.entity;

public class Worker extends Person implements Study{
    public Worker(String name, int age, String sex) {
        super(name, age, sex);
    }

    public void study() {
        System.out.println("我是工人，我叫" + name);
    }
}
