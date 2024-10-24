package com.tian.service.impl;

import com.tian.mapper.AdminMapper;
import com.tian.pojo.UEEResult;
import com.tian.pojo.User;
import com.tian.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<User> list() {
        return adminMapper.list();
    }

    @Override
    public void update(User user) {
        adminMapper.update(user);
    }

    @Override
    public User findByid(Integer id) {
        return adminMapper.findByid(id);
    }

    @Override
    public void delete(Integer id) {
        adminMapper.delete(id);
    }

    @Override
    public List<UEEResult> resultList() {
        return adminMapper.resultList();
    }
}
