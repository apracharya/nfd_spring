package com.teamfilm.mynfd.service.review;

import com.teamfilm.mynfd.service.user.UserModel;
import jakarta.validation.constraints.NotEmpty;
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

    private UserModel user;
}
