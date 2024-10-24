package com.tian.service;

import com.tian.pojo.UEEResult;
import com.tian.pojo.User;

import java.util.List;

public interface AdminService {

    // 分页查询
    List<User> list();

    // 更新
    void update(User user);

    // 根据id查询
    User findByid(Integer id);

    // 删除
    void delete(Integer id);

    // 查询所有考试结果
    List<UEEResult> resultList();
}
