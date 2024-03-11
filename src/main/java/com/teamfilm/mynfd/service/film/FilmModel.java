package com.teamfilm.mynfd.service.film;

import com.teamfilm.mynfd.persistence.category.CategoryEntity;
import com.teamfilm.mynfd.persistence.film.FilmEntity;
import com.teamfilm.mynfd.service.category.CategoryModel;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
public class FilmModel {

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

}
