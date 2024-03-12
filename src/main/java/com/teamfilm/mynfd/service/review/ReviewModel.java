package com.teamfilm.mynfd.service.review;

import com.teamfilm.mynfd.persistence.film.FilmEntity;
import com.teamfilm.mynfd.persistence.user.UserEntity;
import com.teamfilm.mynfd.service.user.UserModel;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class ReviewModel {
    private int id;
    private String body;
    private UserModel user;
}
