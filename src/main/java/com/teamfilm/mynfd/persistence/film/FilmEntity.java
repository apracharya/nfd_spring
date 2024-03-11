package com.teamfilm.mynfd.persistence.film;

import com.teamfilm.mynfd.persistence.category.CategoryEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @Column(name = "cast")
    private List<String> cast;

    @Column(name = "rating")
    private double rating;

    @Column(name = "director")
    private String director;

    @Column(name = "producer")
    private String producer;

    @ManyToOne
    private CategoryEntity category;

}
