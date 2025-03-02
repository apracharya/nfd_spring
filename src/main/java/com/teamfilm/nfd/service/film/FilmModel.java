package com.teamfilm.nfd.service.film;

import com.teamfilm.nfd.service.category.CategoryModel;
import com.teamfilm.nfd.service.review.ReviewModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class FilmModel {
    private int id;
    private String title;
    private String thumbnailSrc;
    private int year;
    private String runtime;
    private String summary;
    private String trailerLink;
    private List<String> cast;
    private double rating;
    private CategoryModel category;
    private String director;
    private List<String> producer;
    private String cameraman;
    private Set<ReviewModel> reviews;

}
