package br.com.eduardo.springcrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.eduardo.springcrud"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfo("Documentation for Spring Crud",
                "Documentation from Swagger", "V2", "http://localhost:8080/swagger-ui/",
                new Contact("Eduardo Beltran Michea", "http://localhost:8080/swagger-ui/", "eduardomichea2001@hotmail.com"),
                "Licence", "http://localhost:8080/swagger-ui/",
                Collections.emptyList());
    }


}
