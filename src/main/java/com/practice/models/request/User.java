package com.practice.models.request;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    int id;
    String username;
    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    int age;
    boolean hasPet;
}
