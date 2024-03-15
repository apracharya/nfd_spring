package com.teamfilm.mynfd.service.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    @NotEmpty
    @Size(min = 4, max = 30)
    String username;

    @NotEmpty
    String firstName;

    @NotEmpty
    String lastName;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 30)
    String password;
    Set<RoleModel> roles;

}
