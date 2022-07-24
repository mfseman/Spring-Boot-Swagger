package com.practice.models.springdocs.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {


    // The @Size validation will overwrite anything placed inside of @Schema for minimum and maximum sizes
    // @Size(min = Integer.MIN_VALUE, max = Integer.MAX_VALUE, message = "ID must be a valid size")
    @Schema(
            title = "Value of an id",
            description = "ID is required due to xyz...",
            required = true,
            minimum = "0",
            maximum = "10000",
            example = "5")
    int id;

    @Schema(
            title = "A users username",
            description = "Username is required to identify a user",
            required = true,
            pattern = "/^[a-z ,.'-]+$/i",
            example = "swagger_pro")
    String username;

    @Schema(
            title = "Does user have a pet?",
            description = "Do you have a puppers, doge, kitty?",
            example = "false",
            defaultValue = "false")
    boolean hasPet;

    @Schema(
            deprecated = true,
            defaultValue = "Bazinga")
    String invisibleField;
}
