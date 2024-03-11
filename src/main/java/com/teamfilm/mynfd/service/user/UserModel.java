package com.teamfilm.mynfd.service.user;

import com.teamfilm.mynfd.persistence.user.UserEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record UserModel(@Size(min=5, max = 25) String username,
                        String firstName,
                        String lastName,
                        String password) {



    public UserEntity toEntity() {
        return UserEntity.builder()
                .username(username)
                .firstName(firstName)
                .lastName(lastName)
                .password(password)
                .build();
    }

    public static UserModel fromEntity(UserEntity entity) {
        return UserModel.builder()
                .username(entity.getUsername())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .password(entity.getPassword())
                .build();
    }
}
