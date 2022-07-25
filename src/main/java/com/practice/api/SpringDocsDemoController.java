package com.practice.api;

import com.practice.models.springdocs.request.User;
import com.practice.models.springdocs.response.UserAPIResponse;
import com.practice.models.springdocs.swagger.SwaggerSuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@RequestMapping(path = "/api")
public class SpringDocsDemoController {

    @Operation(summary = "Swagger Docs Summary", description = "Swagger Docs Description", tags = {"Spring Docs Example"},
            responses = {
            @ApiResponse(responseCode = "200", description = "SUCCESS!!!!!", content = @Content(schema =
            @Schema(implementation = SwaggerSuccessResponse.class))),
            @ApiResponse(responseCode = "400", description = "YOUR REQUEST IS BAD!!!!!"),
            @ApiResponse(responseCode = "404", description = "THIS AINT FOUND!!!!!"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR!!!!!")})
    @PostMapping(path = "/springdocs", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAPIResponse> createUser(
            @Parameter(description = "Authentication is Required", required = true)
            @Pattern(regexp = "(password|taco)", message = "Invalid Password")
            @Size(min = 4, max = 8, message = "Invalid Size")
            @RequestHeader("Authorization") String Authentication,
            @RequestBody User user) {
        return null;
    }
}
