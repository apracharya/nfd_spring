package com.teamfilm.mynfd.service.user;

import com.teamfilm.mynfd.persistence.user.UserEntity;
import lombok.Builder;

@Builder
public record UserModel(int id,
                        String firstName,
                        String lastName,
                        String username,
                        String password) {



    public UserEntity toEntity() {
        return UserEntity.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .username(username)
                .password(password)
                .build();
    }

    public static UserModel fromEntity(UserEntity entity) {
        return UserModel.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .build();
    }
}
