package com.tian.service;

import com.tian.pojo.Info;

import java.util.List;

public interface InfoService {

    //添加
    void add(Info info);

    //查询
    Info findById(Integer id);

    //修改
    void update(Info info);

    //删除
    void delete(Integer id);

    //查询
    List<Info> list();
}
