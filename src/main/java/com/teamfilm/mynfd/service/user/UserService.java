package com.teamfilm.mynfd.service.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    UserModel createUser(UserModel film);
    Optional<UserModel> readUser(int id);

    List<UserModel> readAllUsers();

    UserModel updateUser(UserModel userModel, int userId);
    void deleteUser(int id);

    boolean authenticate(String token);
}
