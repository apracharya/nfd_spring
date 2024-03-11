//package com.teamfilm.mynfd.response.film;
//
//import com.teamfilm.mynfd.persistence.film.FilmEntity;
//import com.teamfilm.mynfd.service.category.CategoryModel;
//import com.teamfilm.mynfd.service.film.FilmModel;
//
//public class FilmResponseMapper {
//	private FilmResponseMapper() {
//
//	}
//
//	public static FilmPostResponse toPostResponse(FilmModel response) {
//		return FilmPostResponse.builder()
//				.message("Film created")
//				.title(response.title())
//				.thumbnailSrc(response.thumbnailSrc())
//				.year(response.year())
//				.category(CategoryModel.fromEntity(response.category()))
//				.runtime(response.runtime())
//				.summary(response.summary())
//				.cast(response.cast())
////				.crew(response.crew())
//				.trailerLink(response.trailerLink())
//				.rating(response.rating())
//				.build();
//	}
//
//
////	public static FilmGetResponse toGetResponse(FilmModel response) {
////		return FilmGetResponse.builder()
////				.message("Film found")
////				.title(response.title())
////				.thumbnailSrc(response.thumbnailSrc())
////				.year(response.year())
////				.category(response.category())
////				.runtime(response.runtime())
////				.summary(response.summary())
////				.cast(response.cast())
////				.crew(response.crew())
////				.trailerLink(response.trailerLink())
////				.rating(response.rating())
////				.reviewId(response.reviewId())
////				.build();
////	}
//
//	public static FilmGetResponse toGetResponse(FilmModel response) {
//		return FilmGetResponse.builder()
//				.message("Film found")
//				.title(response.title())
//				.thumbnailSrc(response.thumbnailSrc())
//				.year(response.year())
//				.runtime(response.runtime())
//				.summary(response.summary())
//				.cast(response.cast())
//				.trailerLink(response.trailerLink())
//				.rating(response.rating())
//				.director(response.director())
//				.producer(response.producer())
//				.category(response.category())
//				.build();
//	}
//
//	public static AllFilmGetResponse toGetAllResponse(FilmModel response) {
//		return AllFilmGetResponse.builder()
//				.build();
//	}
//
//
//	public static FilmPutResponse toPutResponse(FilmModel response) {
//		return FilmPutResponse.builder()
//				.message("Film updated")
//				.title(response.title())
//				.thumbnailSrc(response.thumbnailSrc())
//				.year(response.year())
//				.runtime(response.runtime())
//				.summary(response.summary())
//				.cast(response.cast())
////				.crew(response.crew())
//				.trailerLink(response.trailerLink())
//				.rating(response.rating())
//				.build();
//	}
//
//
//}
