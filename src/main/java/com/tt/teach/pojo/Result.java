package com.tt.teach.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 *@作者：guojialong
 *@时间：2018/12/19 10:31
 *@描述：成绩表 Result
*/
public class Result implements Serializable {
    private Integer resultNo;
    private Integer studentNo;
    private Integer subjectNo;
    private Date examDate;
    private Integer studentResult;

    public Integer getResultNo() {
        return resultNo;
    }

    public void setResultNo(Integer resultNo) {
        this.resultNo = resultNo;
    }

    public Integer getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }

    public Integer getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(Integer subjectNo) {
        this.subjectNo = subjectNo;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public Integer getStudentResult() {
        return studentResult;
    }

    public void setStudentResult(Integer studentResult) {
        this.studentResult = studentResult;
    }

    public Result() {
    }

    public Result(Integer resultNo, Integer studentNo, Integer subjectNo, Date examDate, Integer studentResult) {
        this.resultNo = resultNo;
        this.studentNo = studentNo;
        this.subjectNo = subjectNo;
        this.examDate = examDate;
        this.studentResult = studentResult;
    }
}
