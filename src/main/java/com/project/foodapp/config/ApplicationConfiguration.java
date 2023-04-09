package com.project.foodapp.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfiguration {
	
	@Bean
	public Docket getDocket() {
		Contact contact = new Contact("TestYantra", "www.testyantra.com", "testyantra@gmailcom");
		List<VendorExtension> extensions = new ArrayList<>();
		ApiInfo apiInfo = new ApiInfo("Food App","Food App API for In-House orders",
				"1.01 Final", "services free 1 year", contact, "testyantralicence@234",
				"www.testyantra.com", extensions);
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.project.foodapp")).build()
				.apiInfo(apiInfo).useDefaultResponseMessages(false);
	}
}


























