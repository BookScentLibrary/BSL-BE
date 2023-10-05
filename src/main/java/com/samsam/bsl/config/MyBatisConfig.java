package com.samsam.bsl.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@MapperScan(value = "com.samsam.bsl", sqlSessionFactoryRef = "sqlSessionFactory")
public class MyBatisConfig {

  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
    SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);

    sqlSessionTemplate.getConfiguration().setMapUnderscoreToCamelCase(true);

    return new SqlSessionTemplate(sqlSessionFactory);
  }

  @Bean
  public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception {
    SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
    sessionFactoryBean.setDataSource(dataSource);
    sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
    //실제로 쿼리가 들어갈 xml 패키지 경로
//    sessionFactoryBean.setTypeAliasesPackage("com.samsam.bsl.postProgram.dto");
    //DTO를 선언해 놓은 package 경로
    //Wapper의 result. paramaterType의 패키지 경로를 클래스만 작성할 수 있도록 도와줌
    return sessionFactoryBean;

  }

  @Bean
  public PlatformTransactionManager transactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }
}