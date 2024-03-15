package com.teamfilm.mynfd.service;

import com.teamfilm.mynfd.service.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JWTResponse {

    private String jwtToken;
    private String username;

//    private UserModel user;
}
