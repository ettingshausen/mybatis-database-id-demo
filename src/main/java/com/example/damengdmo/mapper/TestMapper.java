package com.example.damengdmo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
@Mapper
public interface TestMapper {
    @Select("select COLUMN_1, COLUMN_2 from t_test")
    List<Map> list();

    List<Map> queryList();

    @Insert("insert into t_test (COLUMN_1, COLUMN_2) values (#{v1}, #{v2})")
    int insert(Map map);

    @Delete("delete from t_test")
    void delete();
}
