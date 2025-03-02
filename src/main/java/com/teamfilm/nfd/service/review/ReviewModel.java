package com.teamfilm.nfd.service.review;

import com.teamfilm.nfd.service.user.UserModel;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReviewModel {
    private int id;

    @NotEmpty
    @Size(min = 5)
    private String body;

    @NotNull
    private double rating;

    private UserModel user;
}
