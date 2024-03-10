package com.test;

import com.test.entity.Student;
import com.test.mapper.TestMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try(SqlSession session = MybatisUtil.getSession(true)) {
            TestMapper mapper = session.getMapper(TestMapper.class);
            Student s1 = mapper.getStudentBySid(1);
            mapper.addStudent(new Student().setName("xx").setSex("男").setSid(6));
            Student s2 = mapper.getStudentBySid(1);
            System.out.println(s1 == s2);
        }
    }
}
