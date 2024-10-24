package com.tian.mapper;

import com.tian.pojo.Info;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InfoMapper {

    // 添加一条数据
    @Insert("insert into info(user_id, title, content, type, time)" +
            "values(#{userId}, #{title}, #{content}, #{type}, curdate())")
    void add(Info info);

    // 根据id查询一条数据
    @Select("select * from info where id = #{id}")
    Info findById(Integer id);

    // 修改一条数据
    @Update("update info set title = #{title}, content = #{content}, time = now() where id = #{id}")
    void update(Info info);

    // 删除一条数据
    @Delete("delete from info where id = #{id}")
    void delete(Integer id);

    // 查询所有数据
    @Select("select * from info")
    List<Info> list();


}
