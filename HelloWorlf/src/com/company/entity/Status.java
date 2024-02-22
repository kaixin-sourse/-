package com.company.entity;

public enum Status {
    RUNNING("跑步", 18),STUDY("学习",14),SLEEP("睡觉",18);


    private final String name;
    private final int age;
    Status(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
}
