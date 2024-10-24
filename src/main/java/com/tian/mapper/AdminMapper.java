package com.tian.mapper;

import com.tian.pojo.UEEResult;
import com.tian.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminMapper {

    // 查询所有用户
    @Select("select * from user")
    List<User> list();

    // 修改用户信息
    @Update("update user set role = #{role}, state = #{state} where id = #{id}")
    void update(User user);

    // 根据id查询用户
    @Select("select * from user where id = #{id}")
    User findByid(Integer id);

    // 删除用户
    @Delete("delete from user where id = #{id}")
    void delete(Integer id);

    // 查询所有考试记录
    @Select("select user.username,exam.start_time,exam.end_time,eresult.score,eresult.record from user,exam,eresult where user.id=eresult.user_id and exam.id=eresult.exam_id")
    List<UEEResult> resultList();
}
