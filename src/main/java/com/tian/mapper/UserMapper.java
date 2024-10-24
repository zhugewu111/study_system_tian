package com.tian.mapper;

import com.tian.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    // 根据用户名查询用户
    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    // 添加
    @Insert("insert into user(username, password)" +
            " values(#{username}, #{password})")
    void add(String username, String password);

    // 更新
    @Update("update user set username=#{username}, password=#{password}, email=#{email}, sex=#{sex}, phone=#{phone}, age=#{age} where id=#{id}")
    void update(User user);

    // 查询所有资源
    @Select("select * from resources")
    List<Resources> list();

    // 根据id查询资源
    @Select("select uname from resources where id = #{id}")
    String findById(Integer id);

    // 添加信息
    @Insert("insert into info(user_id, title, content, type, time)" +
            "values(#{userId}, #{title}, #{content}, #{type}, now())")
    void addInfo(Info info);

    // 根据id查询问题
    @Select("select * from question where id = #{id}")
    Question question(Integer id);

    // 查询所有问题
    @Select("select * from question")
    List<Question> exam();

    // 根据id查询用户
    @Select("select * from user where id = #{id}")
    User findUserById(Integer id);

    // 查询所有考试
    @Select("select * from exam")
    List<Exam> examList();

    // 根据id查询考试
    @Select("select num from exam where id = #{id}")
    Integer findExamById(Integer id);

    // 添加考试结果
    @Insert("insert into eresult(exam_id, user_id, score, record)" +
            "values(#{examId}, #{userId}, #{score}, #{record})")
    void addEResult(EResult eResult);
}
