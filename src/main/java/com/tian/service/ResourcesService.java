package com.tian.service;

import com.tian.pojo.Resources;

import java.util.List;

public interface ResourcesService {

    // 添加资源
    void add(Resources resources);

    // 根据id查询资源
    Resources findById(Integer id);

    // 删除
    void delete(Integer id);

    // 查询所有
    List<Resources> list();
}
