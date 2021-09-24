package com.example.damengdmo.config;


import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {

    @Bean
    public DatabaseIdProvider databaseIdProvider() {
        return new VendorDatabaseIdProvider();
    }
}
