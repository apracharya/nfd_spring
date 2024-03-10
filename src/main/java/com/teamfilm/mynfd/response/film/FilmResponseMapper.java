package com.teamfilm.mynfd.response.film;

import com.teamfilm.mynfd.persistence.film.FilmEntity;
import com.teamfilm.mynfd.service.film.FilmModel;

public class FilmResponseMapper {
	private FilmResponseMapper() {
		
	}
	
	public static FilmPostResponse toPostResponse(FilmModel response) {
		return FilmPostResponse.builder()
				.message("Film created")
				.imdbId(response.imdbId())
				.title(response.title())
				.thumbnailSrc(response.thumbnailSrc())
				.year(response.year())
				.genre(response.genre())
				.runtime(response.runtime())
				.summary(response.summary())
				.cast(response.cast())
//				.crew(response.crew())
				.trailerLink(response.trailerLink())
				.rating(response.rating())
				.build();
	}

	
//	public static FilmGetResponse toGetResponse(FilmModel response) {
//		return FilmGetResponse.builder()
//				.message("Film found")
//				.title(response.title())
//				.thumbnailSrc(response.thumbnailSrc())
//				.year(response.year())
//				.genre(response.genre())
//				.runtime(response.runtime())
//				.summary(response.summary())
//				.cast(response.cast())
//				.crew(response.crew())
//				.trailerLink(response.trailerLink())
//				.rating(response.rating())
//				.reviewId(response.reviewId())
//				.build();
//	}

	public static FilmGetResponse toGetResponse(FilmModel response) {
		return FilmGetResponse.builder()
				.message("Film found")
				.title(response.title())
				.thumbnailSrc(response.thumbnailSrc())
				.year(response.year())
				.genre(response.genre())
				.runtime(response.runtime())
				.summary(response.summary())
				.cast(response.cast())
//				.crew(response.crew())
				.trailerLink(response.trailerLink())
				.rating(response.rating())
//				.reviewId(response.reviewId())
				.build();
	}

	public static AllFilmGetResponse toGetAllResponse(FilmModel response) {
		return AllFilmGetResponse.builder()
				.build();
	}


	public static FilmPutResponse toPutResponse(FilmModel response) {
		return FilmPutResponse.builder()
				.message("Film updated")
				.imdbId(response.imdbId())
				.title(response.title())
				.thumbnailSrc(response.thumbnailSrc())
				.year(response.year())
				.genre(response.genre())
				.runtime(response.runtime())
				.summary(response.summary())
				.cast(response.cast())
//				.crew(response.crew())
				.trailerLink(response.trailerLink())
				.rating(response.rating())
				.build();
	}
	
	
}
