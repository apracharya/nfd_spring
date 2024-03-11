package com.teamfilm.mynfd.request.film;

import com.teamfilm.mynfd.persistence.category.CategoryEntity;

import java.util.List;
import java.util.Map;

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
