package com.samsam.bsl.review.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "com.samsam.bsl", sqlSessionFactoryRef = "SqlSessionFactory")
public class MyBatisConfig {
}