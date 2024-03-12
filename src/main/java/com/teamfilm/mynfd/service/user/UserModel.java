package com.teamfilm.mynfd.service.user;

import com.teamfilm.mynfd.persistence.review.ReviewEntity;
import com.teamfilm.mynfd.persistence.user.UserEntity;
import com.teamfilm.mynfd.service.review.ReviewModel;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class UserModel {

    String username;
    String firstName;
    String lastName;
    String password;
    Set<ReviewEntity> reviews;

}
