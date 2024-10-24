package com.tian.controller;

import com.tian.pojo.Resources;
import com.tian.pojo.Result;
import com.tian.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/resources")
public class ResourcesController {

    @Autowired
    private ResourcesService resourcesService;

    @PostMapping
    public Result upload(@RequestParam("file") MultipartFile file) throws Exception {
        //把文件内容存储到本地磁盘上
        String originalFilename = file.getOriginalFilename();
        //保证文件名唯一，防止覆盖
        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("." ));
        String path = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static").toString() + "\\";
//        file.transferTo(new File("C:\\Users\\TZYHL\\Desktop\\devlop\\study_system\\src\\main\\resources\\static\\" + fileName));
        file.transferTo(new File(path + fileName));
        // 将原名称和uid名称添加到数据库
        Resources resources = new Resources();
        resources.setName(originalFilename);
        resources.setUname(fileName);
        resourcesService.add(resources);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(Integer id) {
        // 获取文件uid名称
        Resources resources = resourcesService.findById(id);
        String uname = resources.getUname();
        // 删除本地磁盘上的文件
        String path = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static").toString() + "\\";
        new File(path + uname).delete();
//        new File("C:\\Users\\TZYHL\\Desktop\\devlop\\study_system\\src\\main\\resources\\static\\" + uname).delete();
        resourcesService.delete(id);
        return Result.success();
    }

    @GetMapping
    public Result<List<Resources>> list(){
        List<Resources> as = resourcesService.list();
        return Result.success(as);
    }

}
