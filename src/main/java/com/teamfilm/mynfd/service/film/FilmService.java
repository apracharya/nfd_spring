package com.teamfilm.mynfd.service.film;

import com.teamfilm.mynfd.persistence.film.FilmEntity;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    FilmModel createFilm(FilmModel film, int categoryId);
    Optional<FilmModel> readFilm(int filmId);
    FilmModel updateFilm(FilmModel film, Integer filmId);
    List<FilmModel> readAllFilms();
    void deleteFilm(int filmId);
    List<FilmEntity> readFilmByCategory(int categoryId);
    List<FilmEntity> searchFilm(String keyword);
}