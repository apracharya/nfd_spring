package com.teamfilm.mynfd.service.film;

import com.teamfilm.mynfd.exception.NotFoundException;
import com.teamfilm.mynfd.persistence.category.CategoryEntity;
import com.teamfilm.mynfd.persistence.category.CategoryRepository;
import com.teamfilm.mynfd.persistence.film.FilmEntity;
import com.teamfilm.mynfd.persistence.film.FilmRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FilmServiceImplementation implements FilmService {

    private FilmRepository filmRepository;

    private CategoryRepository categoryRepository;

    private ModelMapper modelMapper;

    public FilmServiceImplementation(FilmRepository filmRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.filmRepository = filmRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FilmModel createFilm(FilmModel film, int categoryId) {

        CategoryEntity category = categoryRepository.findById(categoryId)
                .orElseThrow(NotFoundException::new);

        FilmEntity entity = modelMapper.map(film, FilmEntity.class);
        entity.setThumbnailSrc("default.png");
        entity.setCategory(category);

        FilmEntity created = filmRepository.save(entity);

        return modelMapper.map(created, FilmModel.class);
    }

    @Override
    public Optional<FilmModel> readFilm(int filmId) {
        return Optional.empty();
    }

    @Override
    public FilmModel updateFilm(FilmModel film, Integer filmId) {
        return null;
    }

    @Override
    public List<FilmModel> readAllFilms() {
        return null;
    }

    @Override
    public void deleteFilm(int filmId) {

    }

    @Override
    public List<FilmEntity> readFilmByCategory(int categoryId) {
        return null;
    }

    @Override
    public List<FilmEntity> searchFilm(String keyword) {
        return null;
    }


//    @Override
//    public Optional<FilmModel> readFilm(int filmId) {
//        return filmRepository.findById(filmId)
//                .map(FilmModel::fromEntity);
//    }
//
//    @Override
//    public List<FilmModel> readAllFilms() {
//        return filmRepository.findAll()
//                .stream()
//                .map(FilmModel::fromEntity)
//                .toList();
//    }
//
//
//    @Override
//    public FilmModel updateFilm(FilmModel film, Integer filmId) {
//        FilmEntity movie = filmRepository.findById(filmId)
//                .orElseThrow(() -> new NotFoundException("Film with ID " + filmId + " not found"));
//        movie.setTitle(film.title());
//        movie.setYear(film.year());
//        movie.setRuntime(film.runtime());
//        movie.setSummary(film.summary());
//        movie.setTrailerLink(film.trailerLink());
//        movie.setCast(film.cast());
//        movie.setRating(film.rating());
//        FilmEntity updated = filmRepository.save(movie);
//        return FilmModel.fromEntity(updated);
//    }
//
//
//    @Override
//    public void deleteFilm(int id) {
//        filmRepository.deleteById(id);
//    }
//
//    @Override
//    public List<FilmEntity> readFilmByCategory(int categoryId) {
//        return null;
//    }
//
//    @Override
//    public List<FilmEntity> searchFilm(String keyword) {
//        return null;
//    }
}
