package com.tian;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class pathName {

    @Test
    public void test1(){
//        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\";
        String resources = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static").toString() + "\\";
//        System.out.println(path);
        System.out.println(resources);
    }
}

