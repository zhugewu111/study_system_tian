package com.tian.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Resources {
    private Integer id;// 资源id
    private String name;// 名称
    private String uname;// uid名称
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String time;// 上传时间
}
