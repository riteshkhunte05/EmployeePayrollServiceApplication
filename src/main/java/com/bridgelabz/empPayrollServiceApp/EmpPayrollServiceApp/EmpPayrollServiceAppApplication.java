package com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class EmpPayrollServiceAppApplication {

	public static void main(String[] args) {
		System.out.println("Welcome To Employee PayRoll Service Application");
		SpringApplication.run(EmpPayrollServiceAppApplication.class, args);
	}
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp"))
				.build();
	}
}

