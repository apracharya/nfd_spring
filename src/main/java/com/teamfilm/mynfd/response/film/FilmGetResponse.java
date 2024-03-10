package com.teamfilm.mynfd.response.film;

import com.teamfilm.mynfd.response.Response;
import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public record FilmGetResponse(String message,
							  String title,
							  String thumbnailSrc,
							  int year,
							  List<String> genre,
							  double rating,
							  String runtime,
							  String summary,
							  String trailerLink,
							  List<String> cast
							  /*Map<String, String> crew*/
							  /*List<ReviewEntity> reviewId*/) implements Response {

}
