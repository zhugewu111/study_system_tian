package com.tian.service;

import com.tian.pojo.Question;

import java.util.List;

public interface QuestionService {

    //添加问题
    void add(Question question);

    //根据id查找问题
    Question findById(Integer id);

    //修改问题
    void update(Question question);

    //删除问题
    void delete(Integer id);

    //查询所有问题
    List<Question> list();
}
