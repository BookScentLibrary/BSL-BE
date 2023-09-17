package com.samsam.bsl.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  private String version = "1.0";
  private String title = "BookScentLibrary API " + version;

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.OAS_30)
      .consumes(getConsumeContentTypes())
      .produces(getProduceContentTypes())
      .apiInfo(apiInfo(title, version))
      .select()
      .apis(RequestHandlerSelectors.any())
      .paths(PathSelectors.any())
      .build();
  }

  private Set<String> getConsumeContentTypes() {
    Set<String> consumes = new HashSet<>();
    consumes.add("application/json;charset=UTF-8");
    consumes.add("application/x-www-form-urlencoded");
    return consumes;
  }

  private Set<String> getProduceContentTypes() {
    Set<String> produces = new HashSet<>();
    produces.add("application/json;charset=UTF-8");
    return produces;
  }


  private ApiInfo apiInfo(String title, String version) {
    return new ApiInfoBuilder()
      .title(title)
      .description("Swagger로 생성한 API Docs")
      .version(version)
      .build();


  }
}