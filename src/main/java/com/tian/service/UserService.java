package com.tian.service;

import com.tian.pojo.*;

import java.util.List;

public interface UserService {

    // 根据用户名查询用户
    User findByUsername(String username);

    // 注册
    void register(String username, String password);

    // 更新
    void update(User user);

    // 获取所有资源
    List<Resources> list();

    // 根据id查询资源
    String findById(Integer id);

    // 添加信息
    void addInfo(Info info);

    // 获取题目
    Question question(Integer id);

    // 获取所有题目
    List<Question> exam();

    // 根据id查询用户
    User findUserById(Integer id);

    // 获取所有考试
    List<Exam> examList();

    // 根据id查询考试并返回题目
    List<Question> findExamById(Integer id);

    // 添加考试结果
    void addEResult(EResult eResult);
}
