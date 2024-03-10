package com.teamfilm.mynfd.service.film;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    FilmModel createFilm(FilmModel film);
    Optional<FilmModel> readFilm(int filmId);
    FilmModel updateFilm(FilmModel film, Integer filmId);
    List<FilmModel> readAllFilms();
    void deleteFilm(int filmId);
}