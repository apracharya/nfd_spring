package com.teamfilm.nfd.response.film;

import com.teamfilm.nfd.persistence.category.CategoryEntity;
import com.teamfilm.nfd.response.Response;
import lombok.Builder;

import java.util.List;

@Builder
public record FilmPutResponse(String message,
							  String title,
							  String thumbnailSrc,
							  int year,
							  CategoryEntity category,
							  double rating,
							  String runtime,
							  String summary,
							  String trailerLink,
							  List<String> cast
							  /*Map<String, String> crew*/) implements Response {

}
