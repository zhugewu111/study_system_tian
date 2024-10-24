package com.tian.pojo;

import lombok.Data;

@Data
public class Question {
    private Integer id;//题目编号
    private String title;//标题
    private String content;//题目内容
    private String options;//选项内容
    private String level;//难度(简单|普通|困难) level(easy|common|hard)
    private String type;//题目类型
    private String answer;//答案
}
