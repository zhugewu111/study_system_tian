package com.tian.mapper;

import com.tian.pojo.Exam;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExamMapper {

    // 添加考试
    @Insert("insert into exam(start_time,end_time,rule,num) values(#{startTime},#{endTime},#{rule},#{num})")
    void add(Exam exam);

    // 根据id查询考试
    @Select("select * from exam where id = #{id}")
    Exam findById(Integer id);

    // 修改考试
    @Update("update exam set start_time = #{startTime},end_time = #{endTime},rule = #{rule},num = #{num} where id = #{id}")
    void update(Exam exam);

    // 删除考试
    @Delete("delete from exam where id = #{id}")
    void delete(Integer id);

    // 查询所有考试
    @Select("select * from exam")
    List<Exam> list();
}
