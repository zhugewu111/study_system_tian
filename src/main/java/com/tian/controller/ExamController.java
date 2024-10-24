package com.tian.controller;

import com.tian.pojo.Exam;
import com.tian.pojo.Result;
import com.tian.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping
    public Result add(@RequestBody Exam exam) {
        examService.add(exam);
        return Result.success();
    }

    @GetMapping
    public Result<Exam> findById(@RequestParam Integer id) {
        Exam exam = examService.findById(id);
        return Result.success(exam);
    }

    @PatchMapping
    public Result update(@RequestBody Exam exam) {
        examService.update(exam);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        examService.delete(id);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Exam>> list() {
        List<Exam> list = examService.list();
        return Result.success(list);
    }

}
