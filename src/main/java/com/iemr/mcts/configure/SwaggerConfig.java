package com.iemr.mcts.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket productApi()
	{
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(metaData());
	}
	private ApiInfo metaData()
	{
		ApiInfoBuilder builder = new ApiInfoBuilder();
		builder.contact(new Contact("Wipro HCIT", "https://www.wipro.com", "mywipro@wipro.com"));
		builder.description("MCTS APIs for AMRIT");
		builder.version("1.0");
		builder.title("MCTS APIs for AMRIT");
		return builder.build();
	}
//    private ApiInfo metaData() {
//        ApiInfo apiInfo = new ApiInfo(
//                "Spring Boot REST API",
//                "Spring Boot REST API for Online Store",
//                "1.0",
//                "Terms of service",
//                new Contact("Wipro HCIT", "https://www.wipro.com", "mywipro@wipro.com"),
//                "",
//                "");
//        return apiInfo;
//    }
}