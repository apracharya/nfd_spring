package com.teamfilm.mynfd.service.film;

import com.teamfilm.mynfd.persistence.film.FilmEntity;
import com.teamfilm.mynfd.service.category.CategoryModel;
import com.teamfilm.mynfd.service.review.ReviewModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class FilmModel {
    int id;
    String title;
    String thumbnailSrc;
    int year;
    String runtime;
    String summary;
    String trailerLink;
    List<String> cast;
    double rating;
    CategoryModel category;
    String director;
    String producer;
    private Set<ReviewModel> reviews;

}
