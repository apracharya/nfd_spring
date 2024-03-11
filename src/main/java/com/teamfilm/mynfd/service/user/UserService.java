package com.teamfilm.mynfd.service.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    UserModel createUser(UserModel film);
    Optional<UserModel> readUser(String username);

    List<UserModel> readAllUsers();

    UserModel updateUser(UserModel userModel, String username);
    void deleteUser(String username);

    boolean authenticate(String token);
}
