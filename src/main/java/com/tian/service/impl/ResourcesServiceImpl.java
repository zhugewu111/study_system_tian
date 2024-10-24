package com.tian.service.impl;

import com.tian.mapper.ResourcesMapper;
import com.tian.pojo.Resources;
import com.tian.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    private ResourcesMapper resourcesMapper;

    @Override
    public void add(Resources resources) {
        resourcesMapper.add(resources);
    }

    @Override
    public Resources findById(Integer id) {
        return resourcesMapper.findById(id);
    }

    @Override
    public void delete(Integer id) {
        resourcesMapper.delete(id);
    }

    @Override
    public List<Resources> list() {
        return resourcesMapper.list();
    }
}
