package com.alopezlanda.kenzanemployees.config;

import static springfox.documentation.builders.PathSelectors.regex;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  Swagger2DocumentationConfiguration springSwaggerConfig;
  
  @Autowired
  public void setSpringSwaggerConfig(Swagger2DocumentationConfiguration springSwaggerConfig) {
    this.springSwaggerConfig = springSwaggerConfig;
  }
  
  @Bean
  public Docket api(ServletContext servletContext) {
    ApiInfo apiInfo =
        new ApiInfoBuilder()
            .title("Kenzan Employees")
            .description("Employees operations")
            .contact(
                new Contact(
                    "Alejandro Lopez Landa",
                    "https://github.com/tezka/kenzan-employees.git",
                    "alopezl.dev@gmail.com"))
            .build();


    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(regex("/kenzan/v1/employee/.*"))
        .build()
        .apiInfo(apiInfo)
        .useDefaultResponseMessages(false);
  }
}
