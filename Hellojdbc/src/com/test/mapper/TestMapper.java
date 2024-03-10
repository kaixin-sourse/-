package com.test.mapper;

import com.test.entity.Student;
import com.test.entity.Teacher;

import java.util.List;
import java.util.Map;

public interface TestMapper {
    List<Student> selectStudent(int tid); //这个是告诉我该函数返回的属性是什么，具体为List<Student>
    Student getStudentBySid(int sid);
    int addStudent(Student student);
    int deleteStudent(int sid);
}
