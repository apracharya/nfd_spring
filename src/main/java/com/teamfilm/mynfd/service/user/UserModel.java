package com.teamfilm.mynfd.service.user;

import com.teamfilm.mynfd.persistence.user.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    String username;
    String firstName;
    String lastName;
    String password;
    Set<RoleModel> roles;

}
