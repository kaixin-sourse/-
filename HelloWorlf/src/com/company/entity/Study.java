package com.company.entity;

public interface Study {
    public abstract void study();
    default void test() {
        System.out.println("我是默认实现");
    }
}
