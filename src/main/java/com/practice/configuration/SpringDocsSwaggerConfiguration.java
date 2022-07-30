package com.practice.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.*;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;

@Configuration
public class SpringDocsSwaggerConfiguration {

    private static final String BEARER_FORMAT = "JWT";
    private static final String SCHEME = "bearer";
    private static final String SECURITY_SCHEME_NAME = "AzureAD";

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
                .contact(new Contact().name("Marco").email("randomEmail@random.com").url("randomURL"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("springboot-swagger")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public OpenApiCustomiser openApiCustomiser() {
        return openApi -> openApi.getComponents().getSchemas().values()
                .forEach(schema -> schema.setAdditionalProperties(false));
    }

    private List<SecurityRequirement> getSecurityRequirement() {
        return List.of(new SecurityRequirement()
                .addList(SECURITY_SCHEME_NAME, List.of("write_user", "read_user")));
    }

    private SecurityScheme getSecurityScheme() {
        return new SecurityScheme()
                .bearerFormat(BEARER_FORMAT)
                .type(SecurityScheme.Type.OAUTH2)
                .flows(oAuthFlows())
                .scheme(SCHEME);
    }

    private OAuthFlows oAuthFlows() {
        return new OAuthFlows()
                .implicit(new OAuthFlow()
                        .authorizationUrl("Authorization URL")
                        .scopes(new Scopes()
                                .addString("write_user", "Add a user")
                                .addString("read_user", "read a user")));
    }
}
