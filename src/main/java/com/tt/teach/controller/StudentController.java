package com.tt.teach.controller;

import com.tt.teach.pojo.Student;
import com.tt.teach.service.StudentService;
import com.tt.teach.utils.BaseController;
import com.tt.teach.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping("/stu")
public class StudentController extends BaseController {
    @Resource
    private StudentService studentService;
    //登录的请求
    //接口：http://localhost:8080/stu/login
    @RequestMapping("/login")
    public String login() {
        return "/student/login";
    }

    //接口：http://localhost:8080/stu/index
    @RequestMapping("/index")
    public String index() {
        String studentName = (String) getSession().getAttribute(SESSION_KEY);
        if (studentName != null){
            return "/student/index";
        }
        return REDIRECT+"/stu/login";
    }
    //学生管理页面的请求
    //接口：http://localhost:8080/stu/student
    @RequestMapping("/student")
    public String student() {
        return "/student/student";
    }
    //登录的方法
    //接口：http://localhost:8080/stu/doLogin
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String doLogin() {
        String xuehao = getRequest().getParameter("studentNo");
        Integer studentNo = Integer.parseInt(xuehao);
        String loginPwd = getRequest().getParameter("loginPwd");
        Student student = new Student();
        student.setStudentNo(studentNo);
        student.setLoginPwd(loginPwd);
        Student student1 = studentService.doLogin(student);
        if (student1 != null){
            getSession().setAttribute(SESSION_KEY,student1.getStudentName());
            return FORWARD+"/stu/index";
        }
        return REDIRECT+"/stu/login";
    }
    //注销
    @RequestMapping("/logout")
    public String logout() {
        getSession().removeAttribute(SESSION_KEY);
        return REDIRECT+"/stu/login";
    }
    //获取所有学生的信息
    @RequestMapping(value = "/findStuAll",method = RequestMethod.GET)
    @ResponseBody
    public Object findStuAll() {
        List<Student> list = studentService.findStuAll();
        return list;
    }
    //修改学生信息的方法
    @RequestMapping(value = "/updateStu",method = RequestMethod.POST)
    public String updateStu() {
        String xuehao = getRequest().getParameter("stuNo");
        Integer stuNo = Integer.parseInt(xuehao);
        String stuName = getRequest().getParameter("stuName");
        String stuPwd = getRequest().getParameter("stuPwd");
        String stuPhone = getRequest().getParameter("stuPhone");
        Student student = new Student();
        student.setStudentName(stuName);
        student.setPhone(stuPhone);
        student.setLoginPwd(stuPwd);
        student.setStudentNo(stuNo);
        int result = studentService.updateStu(student);
        if (result>0){
            return FORWARD+"/stu/student";
        }
        return FORWARD+"/stu/student";
    }
    //删除学生信息的方法
    @RequestMapping(value = "/deleteStu/{stuNo}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteStu(@PathVariable Integer stuNo) {
        int result = studentService.deleteStu(stuNo);
        if (result>0){
            return JsonResult.ok("删除成功！",result);
        }
        return JsonResult.no("删除失败！",result);
    }
}
