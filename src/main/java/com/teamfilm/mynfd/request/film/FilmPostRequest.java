package com.teamfilm.mynfd.request.film;

import com.teamfilm.mynfd.persistence.category.CategoryEntity;
import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public record FilmPostRequest(String title,
							  String thumbnailSrc,
							  int year,
							  double rating,
							  String runtime,
							  String summary,
							  String trailerLink,
							  List<String> cast,
							  String director,
							  List<String> producer) {

}
