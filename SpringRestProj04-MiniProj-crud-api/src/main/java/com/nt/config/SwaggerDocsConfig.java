package com.nt.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerDocsConfig {
	
	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.nt.controller"))
				.paths(PathSelectors.regex("/actor/api.*"))
				.build()
				.useDefaultResponseMessages(true)
				.apiInfo(getApiInfo())
				;
	}
	
	private ApiInfo getApiInfo() {
		Contact contact=new Contact("manas pati","http://moichaa.com/actor","manaspati657@gmail.com");
		return new ApiInfo("Actor info APi",
				"Gives information about actors",
				"2.5 Release",
			    "http://www.molicense.com",
			    contact,
			    "GNU public",
			    "http://apache.org/licence/gnu",
			    Collections.emptyList());
	}

}
