package com.example.damengdmo;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootApplication
public class DamengDmoApplication implements CommandLineRunner {

    final Logger logger = LoggerFactory.getLogger(DamengDmoApplication.class);

    @Resource
    private DatabaseIdProvider databaseIdProvider;

    @Resource
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(DamengDmoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Hello world!");
        logger.info("datasourceId: {}", databaseIdProvider.getDatabaseId(this.dataSource));
    }
}
