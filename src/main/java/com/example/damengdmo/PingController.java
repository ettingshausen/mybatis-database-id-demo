package com.example.damengdmo;

import com.example.damengdmo.mapper.TestMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class PingController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private TestMapper testMapper;

    @GetMapping("/db-version")
    public List ping() {
        return jdbcTemplate.queryForList("SELECT banner as 版本信息 FROM v$version");
    }

    @GetMapping("/1")
    public List list() {
        return jdbcTemplate.queryForList("select \"COLUMN_1\", COLUMN_2 from t_test");
    }

    @GetMapping("/2")
    public List listOfMapper() {
        return testMapper.queryList();
    }

    @GetMapping("/insert")
    public List insert() {

        Map<String, Integer> params = new HashMap<>();
        Random random = new Random();
        params.put("v1", random.nextInt());
        params.put("v2", random.nextInt());
        testMapper.insert(params);
        return testMapper.list();
    }

    @GetMapping("/delete")
    public List delete() {
        testMapper.delete();
        return testMapper.list();
    }

}
