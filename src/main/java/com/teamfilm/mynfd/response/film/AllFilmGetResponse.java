package com.teamfilm.mynfd.response.film;

import com.teamfilm.mynfd.persistence.film.FilmEntity;
import lombok.Builder;

@Builder
public record AllFilmGetResponse(String message,
                                 FilmEntity entity) {
}
