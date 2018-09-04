package com.loan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@ServletComponentScan("com.loan.filter")
@EnableTransactionManagement
@MapperScan("com.loan.dao")
//部署时使用
public class LoanApplication extends SpringBootServletInitializer{
//public class LoanApplication{

	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
//		SpringApplicationBuilder builder = new SpringApplicationBuilder(LoanApplication.class);
//		//修改banner的模式为off
//		builder.bannerMode(Banner.Mode.OFF).run(args);
	}

	//部署时用
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// 注意这里要指向原先用main方法执行的Application启动类
		return builder.sources(LoanApplication.class);
	}
}



