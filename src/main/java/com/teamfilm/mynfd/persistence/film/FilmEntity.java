package com.teamfilm.mynfd.persistence.film;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "films")
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "thumbnil_src")
    private String thumbnailSrc;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "year")
    private Integer year;

    @Column(name = "genre")
    private List<String> genre;

    @Column(name = "runtime")
    private String runtime;

    @Column(name = "summary")
    private String summary;

    @Column(name = "trailer_link")
    private String trailerLink;

    @Column(name = "cast")
    private List<String> cast;

//    @Column(name = "crew")
//    private Map<String, String> crew;

    @Column(name = "rating")
    private double rating;

//    @Column(name = "review_id")
//    private List<ReviewEntity> reviewId;
}
