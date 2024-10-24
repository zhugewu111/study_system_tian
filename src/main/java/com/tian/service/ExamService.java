package com.tian.service;

import com.tian.pojo.Exam;

import java.util.List;

public interface ExamService {

    //添加考试
    void add(Exam exam);

    //根据id查询考试
    Exam findById(Integer id);

    //修改考试
    void update(Exam exam);

    //删除考试
    void delete(Integer id);

    //查询所有考试
    List<Exam> list();
}
