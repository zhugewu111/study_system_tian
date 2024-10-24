package com.tian.service.impl;

import com.tian.mapper.UserMapper;
import com.tian.pojo.*;
import com.tian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }

    @Override
    public void register(String username, String password) {
        //添加
        userMapper.add(username, password);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public List<Resources> list() {
        return userMapper.list();
    }

    @Override
    public String findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public void addInfo(Info info) {
        userMapper.addInfo(info);
    }

    @Override
    public Question question(Integer id) {
        return userMapper.question(id);
    }

    @Override
    public List<Question> exam() {
        return userMapper.exam();
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public List<Exam> examList() {
        return userMapper.examList();
    }

    @Override
    public List<Question> findExamById(Integer id) {
        Integer num = userMapper.findExamById(id);
        List<Question> list = userMapper.exam();
        List<Question> qlist = new ArrayList<>();
        int n;
        for(int i = 0; i < num; i++){
            n = (int)(Math.random() * list.size());
            qlist.add(list.get(n));
            list.remove(n);
        }
        return qlist;
    }

    @Override
    public void addEResult(EResult eResult) {
        userMapper.addEResult(eResult);
    }

}
