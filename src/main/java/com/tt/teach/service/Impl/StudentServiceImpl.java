package com.tt.teach.service.Impl;

import com.tt.teach.dao.StudentDao;
import com.tt.teach.pojo.Student;
import com.tt.teach.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    //登录的方法
    public Student doLogin(Student student) {
        return studentDao.doLogin(student);
    }

    //获取所有学生的信息
    public List<Student> findStuAll() {
        return studentDao.findStuAll();
    }

    //修改学生信息的方法
    @Transactional
    public int updateStu(Student student) {
        return studentDao.updateStu(student);
    }

    //删除学生信息的方法
    @Transactional
    public int deleteStu(Integer stuNo) {
        return studentDao.deleteStu(stuNo);
    }
}
