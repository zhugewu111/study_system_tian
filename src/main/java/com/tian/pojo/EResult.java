package com.tian.pojo;

import lombok.Data;

@Data
public class EResult {
    private Integer id;// 记录id
    private Integer examId;// 考试id
    private Integer userId;// 用户id
    private String score;// 分数
    private String record;// 结果记录
}
