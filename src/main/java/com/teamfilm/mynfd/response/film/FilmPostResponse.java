package com.teamfilm.mynfd.response.film;

import com.teamfilm.mynfd.persistence.category.CategoryEntity;
import com.teamfilm.mynfd.response.Response;
import com.teamfilm.mynfd.service.category.CategoryModel;
import lombok.Builder;

import java.util.List;
import java.util.Map;

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
