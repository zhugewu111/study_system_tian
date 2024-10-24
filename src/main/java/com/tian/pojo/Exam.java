package com.tian.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Exam {
    private Integer id;//考试id
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startTime;//开始时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;//结束时间
    private String rule;//考试规则
    private Integer num;//题目数量
}
