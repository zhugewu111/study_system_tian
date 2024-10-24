package com.tian.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Info {
    private Integer id;// 信息id
    private Integer userId;// 用户id
    private String title;// 标题
    private String content;// 内容
    private String type;// 类型(公告|个人)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String time;// 发布时间
}
