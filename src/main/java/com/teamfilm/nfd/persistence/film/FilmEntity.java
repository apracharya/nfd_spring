package com.teamfilm.nfd.persistence.film;

import com.teamfilm.nfd.persistence.category.CategoryEntity;
import com.teamfilm.nfd.persistence.review.ReviewEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "films")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "thumbnail_src")
    private String thumbnailSrc;

    @Column(name = "year")
    private int year;

    @Column(name = "runtime")
    private String runtime;

    @Column(name = "summary", length = 10000)
    private String summary;

    @Column(name = "trailer_link")
    private String trailerLink;

    @Column(name = "cast", length = 1000)
    private List<String> cast;

    @Column(name = "rating")
    private double rating;

    @Column(name = "director")
    private String director;

    @Column(name = "producer")
    private List<String> producer;

    @Column(name = "cameraman")
    private String cameraman;

    @ManyToOne
    private CategoryEntity category;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private Set<ReviewEntity> reviews;

}
