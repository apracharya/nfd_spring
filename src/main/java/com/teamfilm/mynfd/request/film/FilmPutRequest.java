package com.teamfilm.mynfd.request.film;

import java.util.List;
import java.util.Map;

public record FilmPutRequest(String imdbId,
							 String title,
							 String thumbnailSrc,
							 int year,
							 List<String> genre,
							 double rating,
							 String runtime,
							 String summary,
							 String trailerLink,
							 List<String> cast,
							 Map<String, String> crew) {

}
