package com.rohit.springweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.rohit.springweb.controllers"))
				.paths(PathSelectors.regex("/products.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Product Api").description("Product crud operations")
				.termsOfServiceUrl("Opensource").license("Rohit License").version("2.0").build();
	}

}
