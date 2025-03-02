package com.teamfilm.nfd.response.film;

import com.teamfilm.nfd.response.Response;
import com.teamfilm.nfd.service.category.CategoryModel;
import lombok.Builder;

import java.util.List;

@Builder
public record FilmPostResponse(String message,
							   String title,
							   String thumbnailSrc,
							   int year,
							   CategoryModel category,
							   double rating,
							   String runtime,
							   String summary,
							   String trailerLink,
							   List<String> cast
							   /*Map<String, String> crew*/) implements Response {

}
