package com.test.test;

import com.test.MybatisUtil;
import com.test.entity.Student;
import com.test.mapper.TestMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.NotSerializableException;
import java.util.Arrays;

public class MainTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void before() {
        System.out.println("测试前置初始化中...");
        try {
           sqlSessionFactory = new SqlSessionFactoryBuilder()
                   .build(new FileInputStream("mybatis-config.xml"));
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("测试前置初始化完毕///");
    }
    @After
    public void after() {
        System.out.println("测试阶数！");
    }
    @Test
    public void method() {
        try(SqlSession session = MybatisUtil.getSession(true)) {
            TestMapper testMapper = session.getMapper(TestMapper.class);
            Student student = testMapper.getStudentBySidAndSex(193,"男");
            System.out.println(student);
            Assert.assertEquals(new Student().setName("小刚").setSid(193).setSex("男"),student);
        }
    }

    @Test
    public void method2() {
        System.out.println("我是测试用例2");
    }
}
