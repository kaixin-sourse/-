package com.company;
import com.company.entity.*;

import java.math.BigInteger;

public class Main {


    public static void main(String[] args) {
	// write your code here
        Person person = new Person("",18,"");
        person.SetName("大明");
        System.out.println(person.getName());
        Worker worker = new Worker("",18,"");
        System.out.println(worker.name);
        Student student = new Student("",18,"");
        System.out.println(student.name);

        Person person1 = new Person("小明",18,"男");
        Person person2 = new Person("小明",18,"男");
        System.out.println(person1.equals(person2)); //重写覆盖方法
        System.out.println(person1 == person2);

        Study student1 = new Student("小明",17,"男");
        student1.study();
        student1.test();
        Study ss = new Worker("小明",17,"男");
        ss.test();

        Student student2 = new Student("小明",17,"男");
        student2.setStatus(Status.RUNNING);
        System.out.println(student2.getStatus().getName()); //获取中文名字

        String str = "666";
        Integer i = new Integer(str);
        System.out.println(i*10);
        Integer a = 123;
        //System.out.println(Integer.reverse(12));
        BigInteger ii = BigInteger.valueOf(Long.MAX_VALUE);
        System.out.println(ii.multiply(BigInteger.valueOf(Long.MAX_VALUE))); //如果使用普通的乘法就会溢出，但是BigInteger可以保存
        System.out.println(ii);

        String str1 = "oaaa";
        System.out.println(str1.matches("oa+"));

        String str2 = "ooooooo";
        System.out.println(str2.matches("o+"));
        String str3 = "ooooooo";
        System.out.println(str2.matches("o{7}"));



    }
}
