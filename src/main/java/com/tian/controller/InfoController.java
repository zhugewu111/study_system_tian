package com.tian.controller;

import com.tian.pojo.Info;
import com.tian.pojo.Result;
import com.tian.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @PostMapping
    public Result add(@RequestBody Info info) {
        infoService.add(info);
        return Result.success();
    }

    @GetMapping
    public Result<Info> findById(@RequestParam Integer id) {
        Info info = infoService.findById(id);
        return Result.success(info);
    }

    @PatchMapping
    public Result update(@RequestBody Info info) {
        infoService.update(info);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        infoService.delete(id);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Info>> list() {
        List<Info> list = infoService.list();
        return Result.success(list);
    }
}
