package com.test.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;
import org.w3c.dom.ls.LSOutput;

@Data
@Accessors(chain = true)
public class Student {
    public Student() {
        System.out.println("我被构造了！");
    }
    int sid;
    String name;
    String sex;
}
