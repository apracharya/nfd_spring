package com.teamfilm.mynfd.request.film;

import com.teamfilm.mynfd.service.film.FilmModel;

public class FilmRequestMapper {
	
	private FilmRequestMapper() {
		
	}
	
	public static FilmModel toModel(FilmPostRequest request) {
		return FilmModel.builder()
				.imdbId(request.imdbId())
				.title(request.title())
				.thumbnailSrc(request.thumbnailSrc())
				.year(request.year())
				.genre(request.genre())
				.runtime(request.runtime())
				.summary(request.summary())
				.trailerLink(request.trailerLink())
				.cast(request.cast())
//				.crew(request.crew())
				.rating(request.rating())
				.build();
	}
	
	public static FilmModel toModel(FilmPutRequest request) {
		return FilmModel.builder()
				.imdbId(request.imdbId())
				.title(request.title())
				.thumbnailSrc(request.thumbnailSrc())
				.year(request.year())
				.genre(request.genre())
				.runtime(request.runtime())
				.summary(request.summary())
				.trailerLink(request.trailerLink())
				.cast(request.cast())
//				.crew(request.crew())
				.rating(request.rating())
				.build();
	}
}
