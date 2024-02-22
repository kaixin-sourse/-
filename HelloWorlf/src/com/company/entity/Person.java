package com.company.entity;

import java.util.Objects;

public class Person {
    public String name;
    public int age;
    public String sex;

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void ShowName() {
        System.out.println(this.name);
    }

   /* public static Person getInstance() {
        return new Person();
    }
*/
    public void SetName(String name) {
        if(name.contains("小")) return;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        } else if(obj instanceof Person) {
            Person person = (Person) obj;
            return (this.name.equals(person.name) && this.age == person.age && this.sex.equals(person.sex));
        } else {
            return false;
        }
    }
}
