package com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@Slf4j
@EnableSwagger2
public class EmpPayrollServiceAppApplication {

	public static void main(String[] args) {
		System.out.println("Welcome To Employee PayRoll Service Application");

		log.info("Welcome to Employee Payroll App");
		ApplicationContext context = SpringApplication.run(EmpPayrollServiceAppApplication.class, args);
		log.info("Employee Payroll App Started in {} Environment",
				context.getEnvironment().getProperty("environment"));
		log.info("Employee Payroll DB User is {}",
				context.getEnvironment().getProperty("spring.datasource.username"));

	}

	/*
	 * Method :- Method to Configure Swagger.
	 */

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.bridgelabz.empPayrollServiceApp.EmpPayrollServiceApp"))
				.build();
	}
}

