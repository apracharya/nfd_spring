package com.teamfilm.mynfd.request.film;

import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public record FilmPostRequest(String imdbId,
							  String title,
							  String thumbnailSrc,
							  int year,
							  List<String> genre,
							  double rating,
							  String runtime,
							  String summary,
							  String trailerLink,
							  List<String> cast
							  /*Map<String, String> crew*/) {

}
