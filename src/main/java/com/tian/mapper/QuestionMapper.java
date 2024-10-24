package com.tian.mapper;

import com.tian.pojo.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper {

    // 添加问题
    @Insert("insert into question(title,content,options,level,type,answer) " +
            "values(#{title},#{content},#{options},#{level},#{type},#{answer})")
    void add(Question question);

    // 根据id查询问题
    @Select("select * from question where id=#{id}")
    Question findById(Integer id);

    // 更新问题
    @Update("update question set title=#{title},content=#{content},options=#{options},level=#{level},type=#{type},answer=#{answer} where id=#{id}")
    void update(Question question);

    // 删除问题
    @Delete("delete from question where id=#{id}")
    void delete(Integer id);

    // 查询所有问题
    @Select("select * from question")
    List<Question> list();
}
