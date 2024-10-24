package com.tian.mapper;

import com.tian.pojo.Resources;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ResourcesMapper {

    // 添加资源
    @Insert("insert into resources(name, uname, time)" +
            "values(#{name}, #{uname}, now())")
    void add(Resources resources);

    // 通过id查找
    @Select("select * from resources where id = #{id}")
    Resources findById(Integer id);

    // 通过id删除
    @Delete("delete from resources where id = #{id}")
    void delete(Integer id);

    // 查询所有
    @Select("select * from resources")
    List<Resources> list();
}
