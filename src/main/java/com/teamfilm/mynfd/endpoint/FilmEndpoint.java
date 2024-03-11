package com.teamfilm.mynfd.endpoint;

import com.teamfilm.mynfd.service.film.FilmModel;
import com.teamfilm.mynfd.service.film.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/films")
public class FilmEndpoint {

    @Autowired
    private FilmService filmService;


    @PostMapping("/create/category/{categoryId}")
    public ResponseEntity<FilmModel> createFilm(@RequestBody FilmModel film, @PathVariable("categoryId") int categoryId) {
        FilmModel model = filmService.createFilm(film, categoryId);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }
//
//    @GetMapping("read")
//    public ResponseEntity<List<FilmModel>> readAllFilms() {
//        try {
//            return new ResponseEntity<>(filmService.readAllFilms(), HttpStatus.OK);
//        } catch (Exception e) {
//            log.error("user create: {}", e.getMessage());
//            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
//        }
//    }
//
//    @GetMapping("read/{id}")
//    public ResponseEntity<Response> readFilm(@PathVariable("id") int filmId) {
//        try {
//
//            FilmGetResponse response = filmService.readFilm(filmId)
//                    .map(FilmResponseMapper::toGetResponse)
//                    .orElseThrow(NotFoundException::new);
//            return ResponseEntity.ok(response);
//        } catch(NotFoundException e) {
//            Response response = new ErrorResponse("Film Not found");
//            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            log.error("user read: {}", e.getMessage());
//            Response response = new ErrorResponse("error");
//            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PutMapping("update/{id}")
//    public ResponseEntity<Response> updateFilm(@RequestBody FilmPutRequest request, @PathVariable("id") int filmId) {
//        try {
//            FilmModel model = FilmRequestMapper.toModel(request);
//            FilmPutResponse response = FilmResponseMapper.toPutResponse(filmService.updateFilm(model, filmId));
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (NotFoundException e) {
//            return new ResponseEntity<>(new ErrorResponse("Film not found"), HttpStatus.PRECONDITION_FAILED);
//        } catch (Exception e) {
//            log.error("user update: {}", e.getMessage());
//            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.PRECONDITION_FAILED);
//        }
//    }
//
//    @DeleteMapping("delete/{id}")
//    public void deleteFilm(@PathVariable("id") int filmId) {
//        filmService.deleteFilm(filmId);
//    }
}
