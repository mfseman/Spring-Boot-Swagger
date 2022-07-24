package com.practice.models.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserAPIResponse {

    @Schema(
            title = "User's ID",
            description = "This is the users ID",
            minimum = "0",
            maximum = "10000",
            example = "5")
    int id;

    @Schema(
            title = "Response Code",
            description = "The response code returned to the user",
            minimum = "200",
            maximum = "504",
            example = "0")
    int responseCode;

    @Schema(
            title = "Error message",
            description = "This is an error message returned to the user",
            pattern = "/^[a-z ,.'-]+$/i",
            example = "Invalid Request >:(")
    String errorMessage;
}
