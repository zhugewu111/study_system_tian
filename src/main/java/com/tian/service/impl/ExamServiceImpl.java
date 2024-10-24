package com.tian.service.impl;

import com.tian.mapper.ExamMapper;
import com.tian.pojo.Exam;
import com.tian.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamMapper examMapper;

    @Override
    public void add(Exam exam) {
        examMapper.add(exam);
    }

    @Override
    public Exam findById(Integer id) {
        return examMapper.findById(id);
    }

    @Override
    public void update(Exam exam) {
        examMapper.update(exam);
    }

    @Override
    public void delete(Integer id) {
        examMapper.delete(id);
    }

    @Override
    public List<Exam> list() {
        return examMapper.list();
    }
}
