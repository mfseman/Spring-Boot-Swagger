package com.practice.models.springdocs.swagger;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SwaggerSuccessResponse {

    @Schema(example = "Great Success!!!")
    private String message;
}
