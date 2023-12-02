package com.nt.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerDocsConfig {
	
	
	private ApiKey apiKey() { 
	    return new ApiKey("JWT", "Authorization", "header"); 
	}
	
	private SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }
	
	
	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())
			    .securityContexts(Arrays.asList(securityContext()))
			    .securitySchemes(Arrays.asList(apiKey()))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.nt.restController"))
				.paths(PathSelectors.regex("/api/.*"))
				.build()
				.useDefaultResponseMessages(true)
				
				;
	}
	
	private ApiInfo getApiInfo() {
		Contact contact=new Contact("manas pati","http://userlogin.com/signup","manaspati657@gmail.com");
		return new ApiInfo("User sign in API",
				"Spring Boot REST API sign-in and sign-up",
				"2.5 Release",
			    "http://www.userlogin.com",
			    contact,
			    "GNU public",
			    "http://apache.org/licence/gnu",
			    Collections.emptyList());
	}

}
