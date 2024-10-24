package com.tian.service.impl;

import com.tian.mapper.QuestionMapper;
import com.tian.pojo.Question;
import com.tian.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public void add(Question question) {
        questionMapper.add(question);
    }

    @Override
    public Question findById(Integer id) {
        return questionMapper.findById(id);
    }

    @Override
    public void update(Question question) {
        questionMapper.update(question);
    }

    @Override
    public void delete(Integer id) {
        questionMapper.delete(id);
    }

    @Override
    public List<Question> list() {
        return questionMapper.list();
    }
}
