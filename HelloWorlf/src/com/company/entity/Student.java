package com.company.entity;

public class Student extends Person implements Study{

    private Status status;
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public Student(String name, int age, String sex) {
        super(name, age, sex);
    }

    public void study() {
        System.out.println("我是学生，我叫" + name);
    }
    @Override
    public void test() {
        System.out.println("我是学生实现");
    }
}
