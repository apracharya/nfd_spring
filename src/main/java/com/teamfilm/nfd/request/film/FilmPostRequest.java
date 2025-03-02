package com.teamfilm.nfd.request.film;

import lombok.Builder;

import java.util.List;

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
