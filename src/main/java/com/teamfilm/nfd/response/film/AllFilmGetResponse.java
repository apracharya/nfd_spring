package com.teamfilm.nfd.response.film;

import com.teamfilm.nfd.persistence.film.FilmEntity;
import lombok.Builder;

@Builder
public record AllFilmGetResponse(String message,
                                 FilmEntity entity) {
}
