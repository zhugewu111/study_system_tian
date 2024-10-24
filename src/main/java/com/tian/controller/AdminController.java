package com.tian.controller;

import com.tian.pojo.Result;
import com.tian.pojo.UEEResult;
import com.tian.pojo.User;
import com.tian.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/users")
    public Result<List<User>> list(){
        List<User> list = adminService.list();
        return Result.success(list);
    }

    @GetMapping("/user")
    public Result findByid(@RequestParam Integer id){
        User user = adminService.findByid(id);
        return Result.success(user.getUsername());
    }

    @PatchMapping("/user")
    public Result update(@RequestBody User user){
        adminService.update(user);
        return Result.success();
    }

    @DeleteMapping("/user")
    public Result delete(@RequestParam Integer id){
        adminService.delete(id);
        return Result.success();
    }

    @GetMapping("/result/list")
    public Result<List<UEEResult>> resultList(){
        List<UEEResult> list = adminService.resultList();
        return Result.success(list);
    }

}
