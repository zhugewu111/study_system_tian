package com.tian.service.impl;

import com.tian.mapper.InfoMapper;
import com.tian.pojo.Info;
import com.tian.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public void add(Info info) {
        infoMapper.add(info);
    }

    @Override
    public Info findById(Integer id) {
        return infoMapper.findById(id);
    }

    @Override
    public void update(Info info) {
        infoMapper.update(info);
    }

    @Override
    public void delete(Integer id) {
        infoMapper.delete(id);
    }

    @Override
    public List<Info> list() {
        return infoMapper.list();
    }
}
