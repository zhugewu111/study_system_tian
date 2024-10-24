package com.tian.controller;

import com.tian.pojo.Question;
import com.tian.pojo.Result;
import com.tian.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Result add(@RequestBody Question question) {
        questionService.add(question);
        return Result.success();
    }

    @GetMapping
    public Result<Question> findById(@RequestParam Integer id) {
        Question question = questionService.findById(id);
        return Result.success(question);
    }

    @PatchMapping
    public Result update(@RequestBody Question question) {
        questionService.update(question);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        questionService.delete(id);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Question>> list() {
        return Result.success(questionService.list());
    }
}
