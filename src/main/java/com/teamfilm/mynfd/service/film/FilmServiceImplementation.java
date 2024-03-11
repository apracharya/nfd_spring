package com.teamfilm.mynfd.service.film;

import com.teamfilm.mynfd.exception.NotFoundException;
import com.teamfilm.mynfd.exception.ResourceNotFoundException;
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

    private final FilmRepository filmRepository;

    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    public FilmServiceImplementation(FilmRepository filmRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.filmRepository = filmRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FilmModel createFilm(FilmModel film, int categoryId) {

        CategoryEntity category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category ", "category id", categoryId));

        FilmEntity entity = modelMapper.map(film, FilmEntity.class);
        entity.setThumbnailSrc("default.png");
        entity.setCategory(category);

        FilmEntity created = filmRepository.save(entity);

        return modelMapper.map(created, FilmModel.class);
    }

    @Override
    public FilmModel readFilm(int filmId) {
        FilmEntity film = filmRepository.findById(filmId)
                .orElseThrow(() -> new ResourceNotFoundException("Film", "film id", filmId));
        return modelMapper.map(film, FilmModel.class);
    }

    @Override
    public FilmModel updateFilm(FilmModel film, Integer filmId) {
        FilmEntity entity = filmRepository.findById(filmId)
                .orElseThrow(() -> new ResourceNotFoundException("Film", "film id", filmId));
        entity.setTitle(film.getTitle());
        entity.setThumbnailSrc(film.getThumbnailSrc());
        entity.setYear(film.getYear());
        entity.setRuntime(film.getRuntime());
        entity.setSummary(film.getSummary());
        entity.setTrailerLink(film.getTrailerLink());
        entity.setCast(film.getCast());
        entity.setRating(film.getRating());
        entity.setDirector(film.getDirector());
        entity.setProducer(film.getProducer());

//        entity.setCategory(modelMapper.map(film.getCategory(), CategoryEntity.class));

        FilmEntity updated = filmRepository.save(entity);
        return modelMapper.map(updated, FilmModel.class);
    }

    @Override
    public List<FilmModel> readAllFilms() {
        List<FilmEntity> entity = filmRepository.findAll();
        return entity.stream()
                .map(film -> modelMapper.map(film, FilmModel.class))
                .toList();
    }

    @Override
    public void deleteFilm(int filmId) {
        FilmEntity film = filmRepository.findById(filmId)
                        .orElseThrow(() -> new ResourceNotFoundException("Film", "film id", filmId));
        filmRepository.delete(film);
    }

    @Override
    public List<FilmModel> readFilmsByCategory(int categoryId) {
        CategoryEntity category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
        List<FilmEntity> entity = filmRepository.findByCategory(category);
        return entity.stream()
                .map(film -> modelMapper.map(film, FilmModel.class))
                .toList();
    }

    @Override
    public List<FilmModel> searchFilm(String keyword) {
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
