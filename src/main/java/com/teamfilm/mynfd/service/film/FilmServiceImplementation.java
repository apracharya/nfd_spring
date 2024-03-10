package com.teamfilm.mynfd.service.film;

import com.teamfilm.mynfd.persistence.film.FilmEntity;
import com.teamfilm.mynfd.persistence.film.FilmRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FilmServiceImplementation implements FilmService {

    private final FilmRepository filmRepository;

    public FilmServiceImplementation(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public FilmModel createFilm(FilmModel film) {
        FilmEntity entity = film.toEntity();
        FilmEntity created = filmRepository.save(entity);
        return FilmModel.fromEntity(created);
    }

    @Override
    public FilmModel updateFilm(FilmModel film, Integer filmId) {
        FilmEntity movie = filmRepository.findById(filmId)
                .orElseThrow();
        movie.setThumbnailSrc(film.thumbnailSrc());
        movie.setTitle(film.title());
        movie.setYear(film.year());
        movie.setGenre(film.genre());
        movie.setRuntime(film.runtime());
        movie.setSummary(film.summary());
        movie.setTrailerLink(film.trailerLink());
        movie.setCast(film.cast());
        movie.setRating(film.rating());
        FilmEntity updated = filmRepository.save(movie);
        return FilmModel.fromEntity(updated);
    }

    @Override
    public Optional<FilmModel> readFilm(int filmId) {
        return filmRepository.findById(filmId)
                .map(FilmModel::fromEntity);
    }

    @Override
    public List<FilmModel> readAllFilms() {
        return filmRepository.findAll()
                .stream()
                .map(FilmModel::fromEntity)
                .toList();
    }

    @Override
    public void deleteFilm(int id) {
        filmRepository.deleteById(id);
    }
}
