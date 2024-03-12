package com.teamfilm.mynfd.service.film;

import java.util.List;

public interface FilmService {
    FilmModel createFilm(FilmModel film, int categoryId);
    FilmModel readFilm(int filmId);
    FilmModel updateFilm(FilmModel film, Integer filmId);
    List<FilmModel> readAllFilms(int pageNumber, int pageSize);
    void deleteFilm(int filmId);
    List<FilmModel> readFilmsByCategory(int categoryId);
    List<FilmModel> searchFilm(String keyword);
}