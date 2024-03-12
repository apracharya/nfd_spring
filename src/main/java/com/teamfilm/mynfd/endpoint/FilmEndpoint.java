package com.teamfilm.mynfd.endpoint;

import com.teamfilm.mynfd.response.ApiResponse;
import com.teamfilm.mynfd.service.film.FilmModel;
import com.teamfilm.mynfd.service.film.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/films")
public class FilmEndpoint {

    private final FilmService filmService;

    public FilmEndpoint(FilmService filmService) {
        this.filmService = filmService;
    }

    // create film
    @PostMapping("/create/category/{categoryId}")
    public ResponseEntity<FilmModel> createFilm(@RequestBody FilmModel film, @PathVariable("categoryId") int categoryId) {
        FilmModel model = filmService.createFilm(film, categoryId);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }


    // read films by category
    @GetMapping("/read/category/{categoryId}")
    public ResponseEntity<List<FilmModel>> readFilmsByCategory(@PathVariable("categoryId") int categoryId){
        List<FilmModel> films = filmService.readFilmsByCategory(categoryId);
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    // read all films
    @GetMapping("/read")
    public ResponseEntity<List<FilmModel>> readAllFilms(
            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize
    ) {
        return new ResponseEntity<>(filmService.readAllFilms(pageNumber, pageSize), HttpStatus.OK);
    }

    // read specific film
    @GetMapping("read/{filmId}")
    public ResponseEntity<FilmModel> readFilm(@PathVariable("filmId") int filmId) {
        FilmModel film = filmService.readFilm(filmId);
        return new ResponseEntity<>(film, HttpStatus.OK);

    }

    // update film
    @PutMapping("update/{filmId}")
    public ResponseEntity<FilmModel> updateFilm(@RequestBody FilmModel film, @PathVariable("filmId") int filmId) {
        FilmModel updated = filmService.updateFilm(film, filmId);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // delete film
    @DeleteMapping("delete/{id}")
    public ApiResponse deleteFilm(@PathVariable("id") int filmId) {
        filmService.deleteFilm(filmId);
        return new ApiResponse("Film deleted successfully.", true);
    }
}
