package com.teamfilm.mynfd.endpoint;

import com.teamfilm.mynfd.exception.AlreadyExistsException;
import com.teamfilm.mynfd.exception.NotFoundException;
import com.teamfilm.mynfd.request.film.FilmPostRequest;
import com.teamfilm.mynfd.request.film.FilmPutRequest;
import com.teamfilm.mynfd.request.film.FilmRequestMapper;
import com.teamfilm.mynfd.response.ErrorResponse;
import com.teamfilm.mynfd.response.Response;
import com.teamfilm.mynfd.response.film.FilmGetResponse;
import com.teamfilm.mynfd.response.film.FilmPostResponse;
import com.teamfilm.mynfd.response.film.FilmPutResponse;
import com.teamfilm.mynfd.response.film.FilmResponseMapper;
import com.teamfilm.mynfd.service.film.FilmModel;
import com.teamfilm.mynfd.service.film.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/films")
public class FilmEndpoint {

    private final FilmService filmService;

    public FilmEndpoint(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping("/create")
    public ResponseEntity<Response> createFilm(@RequestBody FilmPostRequest request) {
        try {
            FilmModel model = FilmRequestMapper.toModel(request);
            FilmPostResponse response = FilmResponseMapper.toPostResponse(filmService.createFilm(model));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (AlreadyExistsException e) {
            ErrorResponse response = new ErrorResponse("Film Already Exists");
            return new ResponseEntity<>(response, HttpStatus.PRECONDITION_FAILED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.PRECONDITION_FAILED);
        }
    }

    @GetMapping("read")
    public ResponseEntity<List<FilmModel>> readAllFilms() {
        try {
            return new ResponseEntity<>(filmService.readAllFilms(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
        }
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Response> readFilm(@PathVariable("id") int filmId) {
        try {

            FilmGetResponse response = filmService.readFilm(filmId)
                    .map(FilmResponseMapper::toGetResponse)
                    .orElseThrow(NotFoundException::new);
            return ResponseEntity.ok(response);
        } catch(NotFoundException e) {
            Response response = new ErrorResponse("Film Not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            Response response = new ErrorResponse("error");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Response> updateFilm(@RequestBody FilmPutRequest request, @PathVariable("id") int filmId) {
        FilmModel model = FilmRequestMapper.toModel(request);
        FilmPutResponse response = FilmResponseMapper.toPutResponse(filmService.updateFilm(model, filmId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public void deleteFilm(@PathVariable("id") int filmId) {
        filmService.deleteFilm(filmId);
    }
}
