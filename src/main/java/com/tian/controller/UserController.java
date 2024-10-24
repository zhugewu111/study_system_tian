package com.tian.controller;

import com.tian.pojo.*;
import com.tian.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestParam String username, @Pattern(regexp = "^\\S{5,16}$") String password) {

        //查询用户
        User u = userService.findByUsername(username);
        if (u == null) {
            //没有占用
            //注册
            userService.register(username, password);
            return Result.success();
        } else {
            //占用
            return Result.error("用户名已被占用");
        }
    }

    @PostMapping("/login")
    public Result<User> login(@RequestParam String username, @Pattern(regexp = "^\\S{5,16}$") String password) throws JSONException {

        //根据用户名查询用户
        User loginUser = userService.findByUsername(username);
        //判断用户是否存在
        if (loginUser == null) {
            return Result.error("用户名错误");
        }
        //判断密码是否正确
        if (password.equals(loginUser.getPassword())) {
            //登录成功
            return Result.success(loginUser);
        }
        return Result.error("密码错误");
    }

    @PatchMapping("/update")
    public Result<User> update(@RequestBody User user) {
        userService.update(user);
        User u = userService.findUserById(user.getId());
        return Result.success(u);
    }

    @GetMapping("/resources")
    public Result<List<Resources>> resources() {
        return Result.success(userService.list());
    }

    @GetMapping("/download")
    public Resource download(@RequestParam Integer id) throws Exception {
        String fileName = userService.findById(id);
        Path path = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static", fileName).toAbsolutePath();
        return new FileSystemResource(path);
    }

    @PostMapping("/info")
    public Result addInfo(@RequestBody Info info) {
        userService.addInfo(info);
        return Result.success();
    }

    @GetMapping("/question")
    public Result<Question> question(@RequestParam Integer id) {
        Question question = userService.question(id);
        return Result.success(question);
    }

    @GetMapping("/exam")
    public Result<List<Question>> exam() {
        List<Question> list = userService.exam();
        return Result.success(list);
    }

    @GetMapping("/exam/list")
    public Result<List<Exam>> examList() {
        List<Exam> list = userService.examList();
        return Result.success(list);
    }

    @GetMapping("/exam/start")
    public Result<List<Question>> examStart(@RequestParam Integer id) {
        List<Question> list = userService.findExamById(id);
        return Result.success(list);
    }

    @PostMapping("/exam/end")
    public Result examEnd(@RequestBody EResult eResult) {
        userService.addEResult(eResult);
        return Result.success();
    }

}
