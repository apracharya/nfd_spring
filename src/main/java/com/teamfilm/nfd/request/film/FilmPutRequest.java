package com.teamfilm.nfd.request.film;

import java.util.List;

public record FilmPutRequest(String title,
							 String thumbnailSrc,
							 int year,
							 double rating,
							 String runtime,
							 String summary,
							 String trailerLink,
							 List<String> cast
							 /*Map<String, String> crew*/) {

}
