package com.tt.teach.service;

import com.tt.teach.pojo.Student;

import java.util.List;

public interface StudentService  {
    //登录的方法
    Student doLogin(Student student);
    //获取所有学生的信息
    List<Student> findStuAll();
    //修改学生信息的方法
    int updateStu(Student student);
    //删除学生信息的方法
    int deleteStu(Integer stuNo);
}
