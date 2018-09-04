package com.loan.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by dell on 2018/7/19.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
//    private SpringSwaggerConfig springSwaggerConfig;
//
//    @Autowired
//    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
//        this.springSwaggerConfig = springSwaggerConfig;
//    }
//
//
//    public SwaggerSpringMvcPlugin customImplementation(){
//        return  new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
//                .apiInfo(new ApiInfo("api", "desc", null, null, null, null))
//                .useDefaultResponseMessages(false)
//                .includePatterns("/users.*");
//    }
    @Bean
    public Docket ProductApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .build()
                .apiInfo(productApiInfo());
    }

    private ApiInfo productApiInfo() {
        ApiInfo apiInfo = new ApiInfo("日晟行贷款系统数据接口文档",
                "文档接口描述",
                "1.0.0",
                "API TERMS URL",
                "zhaoyuqi54@gmail.com",
                "Apache License 2.0",
                "license Url");
        return apiInfo;
    }

}
