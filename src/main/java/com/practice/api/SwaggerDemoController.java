package com.practice.api;

import com.practice.models.request.User;
import com.practice.models.response.UserAPIResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class SwaggerDemoController {

    @ApiResponse(responseCode = "200", description = "SUCCESS!!!!!")
    @ApiResponse(responseCode = "400", description = "YOUR REQUEST IS BAD!!!!!")
    @ApiResponse(responseCode = "404", description = "THIS AINT FOUND!!!!!")
    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR!!!!!")
    @PostMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAPIResponse> createUser(
            String Authentication,
            User user) {

        return null;
    }

}
