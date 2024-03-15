package com.teamfilm.mynfd.service.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserModel createUser(UserModel user);
    UserModel readUser(String username);

    List<UserModel> readAllUsers();

    UserModel updateUser(UserModel userModel, String username);
    void deleteUser(String username);

    boolean authenticate(String token);
}
