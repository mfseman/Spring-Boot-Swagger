package com.practice.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfiguration {

    private static final String BEARER_FORMAT = "JWT";
    private static final String SCHEME = "Bearer";
    private static final String SECURITY_SCHEME_NAME = "Security Scheme";

    @Bean
    public OpenAPI swaggerDocs() {
        return new OpenAPI()
                .schemaRequirement(SECURITY_SCHEME_NAME, getSecurityScheme())
                .security(getSecurityRequirement())
                .info(info());
    }

    private Info info() {
        return new Info()
                .title("Spring Boot Swagger API")
                .description("Example of Springdocs swagger usage")
                .version("v0.0.1")
                .contact(new Contact().name("Marco").email("randomEmail").url("randomURL"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("springboot-swagger")
                .pathsToMatch("/api/**")
                .build();
    }

    private List<SecurityRequirement> getSecurityRequirement() {
        SecurityRequirement securityRequirement = new SecurityRequirement();
        securityRequirement.addList(SECURITY_SCHEME_NAME);
        return List.of(securityRequirement);
    }

    private SecurityScheme getSecurityScheme() {
        SecurityScheme securityScheme = new SecurityScheme();
        securityScheme.bearerFormat(BEARER_FORMAT);
        securityScheme.type(SecurityScheme.Type.HTTP);
        securityScheme.in(SecurityScheme.In.HEADER);
        securityScheme.scheme(SCHEME);
        return securityScheme;
    }
}