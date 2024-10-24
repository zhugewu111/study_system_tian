package com.tian.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;//主键ID
    private String username;//用户名
    private String password;//密码
    private String email;//邮箱
    private String sex;//性别
    private String phone;//手机
    private Integer age;//年龄
    private String role;//权限(管理员|用户) role(admin|user)
    private String state;//账号状态(默认|冻结|审核中) state(default|freeze|audit)
}
