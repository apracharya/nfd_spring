package com.teamfilm.mynfd.response.film;

import com.teamfilm.mynfd.persistence.category.CategoryEntity;
import com.teamfilm.mynfd.response.Response;
import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public record FilmGetResponse(String message,
							  String title,
							  String thumbnailSrc,
							  int year,
							  CategoryEntity category,
							  double rating,
							  String runtime,
							  String summary,
							  String trailerLink,
							  List<String> cast,
							  String director,
							  List<String> producer) implements Response {

}
