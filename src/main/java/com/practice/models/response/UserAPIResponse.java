package com.practice.models.response;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserAPIResponse {

    int id;
    int responseCode;
    String message;
}
