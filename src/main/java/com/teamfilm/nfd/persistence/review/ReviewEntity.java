package com.teamfilm.nfd.persistence.review;

import com.teamfilm.nfd.persistence.film.FilmEntity;
import com.teamfilm.nfd.persistence.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "body")
    private String body;

    @Column(name = "rating")
    private double rating;

    @ManyToOne
    private FilmEntity film;

    @ManyToOne
    private UserEntity user;

}
