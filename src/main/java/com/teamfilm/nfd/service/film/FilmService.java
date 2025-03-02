package com.teamfilm.nfd.service.film;

import com.teamfilm.nfd.response.FilmResponse;

import java.util.List;

public interface FilmService {
    FilmModel createFilm(FilmModel film, int categoryId);
    FilmModel readFilm(int filmId);
    FilmModel updateFilm(FilmModel film, Integer filmId);
    FilmResponse readAllFilms(int pageNumber, int pageSize, String sortBy, String sortDir);
    void deleteFilm(int filmId);
    List<FilmModel> readFilmsByCategory(int categoryId);
    List<FilmModel> searchFilms(String keyword);
}