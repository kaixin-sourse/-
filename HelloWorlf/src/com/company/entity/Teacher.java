package com.company.entity;

public class Teacher extends Person implements Study{

    public Teacher(String name, int age, String sex) {
        super(name, age, sex);
    }

    public void study() {
        System.out.println("我是老师");
    }
}
