package com.oxg.branch.app;

//import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.builders;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@EnableAspectJAutoProxy
@ComponentScan( basePackages = "com.oxg.branch.*" )
@EnableMongoRepositories(basePackages = "com.oxg.branch.repository")

public class BranchesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BranchesApplication.class, args);
	}

	
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.oxg.branch.resource"))
	      .paths(PathSelectors.regex("/branches*.*"))
	      .build()
	      .apiInfo(apiInfo());
	}
    
	/*
    private Predicate<String> greetingPah() {
   	 return 
   			 //based on RequestHandler
              regex("/branches*.*");
   }
   */
   
	private ApiInfo apiInfo() {
       return new ApiInfoBuilder()
               .title("Spring REST Sample with Swagger")
               .description("Branches Location Sample with Swagger")
               //.termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
               .contact("Oleg Gilerman")
               .license("Apache License Version 2.0")
               //.licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
               .version("2.0")
               .build();
   }
   
	
}
