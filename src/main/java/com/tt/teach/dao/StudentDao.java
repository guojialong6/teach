package com.tt.teach.dao;

import com.tt.teach.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDao {
    //登录的方法
    @Select("select * from student where studentNo=#{studentNo} and loginPwd=#{loginPwd}")
    Student doLogin(Student student);
    //获取所有学生的信息
    @Select("select student.*,grade.gradeName as gradeName from student,grade where student.gradeId = grade.gradeId")
    List<Student> findStuAll();
    //修改学生信息的方法
    @Update("update student set studentName = #{studentName},loginPwd = #{loginPwd},phone = #{phone} where studentNo = #{studentNo}")
    int updateStu(Student student);
    //删除学生信息的方法
    @Delete("delete from student where studentNo = #{stuNo}")
    int deleteStu(Integer stuNo);
}
