package com.teamfilm.mynfd.service.film;

import com.teamfilm.mynfd.persistence.film.FilmEntity;
import lombok.Builder;

import java.util.List;

@Builder
public record FilmModel(int id,
                        String imdbId,
                        String title,
                        String thumbnailSrc,
                        int year,
                        List<String> genre,
                        String runtime,
                        String summary,
                        String trailerLink,
                        List<String> cast,
                        /*Map<String, String>crew,*/
                        double rating
                        /*List<ReviewEntity> reviewId*/) {

    public FilmEntity toEntity() {
        return FilmEntity.builder()
                .id(id)
                .imdbId(imdbId)
                .title(title)
                .thumbnailSrc(thumbnailSrc)
                .year(year)
                .genre(genre)
                .runtime(runtime)
                .summary(summary)
                .trailerLink(trailerLink)
                .cast(cast)
//                .crew(crew)
                .rating(rating)
//                .reviewId(reviewId)
                .build();
    }

    public static FilmModel fromEntity(FilmEntity entity) {
        return FilmModel.builder()
                .id(entity.getId())
                .imdbId(entity.getImdbId())
                .title(entity.getTitle())
                .thumbnailSrc(entity.getThumbnailSrc())
                .year(entity.getYear())
                .genre(entity.getGenre())
                .runtime(entity.getRuntime())
                .summary(entity.getSummary())
                .trailerLink(entity.getTrailerLink())
                .cast(entity.getCast())
//                .crew(entity.getCrew())
                .rating(entity.getRating())
//                .reviewId(entity.getReviewId())
                .build();
    }

}
