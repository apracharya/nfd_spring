package com.teamfilm.mynfd.endpoint;

import com.teamfilm.mynfd.config.AppConstants;
import com.teamfilm.mynfd.response.ApiResponse;
import com.teamfilm.mynfd.response.FilmResponse;
import com.teamfilm.mynfd.service.film.FileService;
import com.teamfilm.mynfd.service.film.FilmModel;
import com.teamfilm.mynfd.service.film.FilmService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@CrossOrigin("*")
@Slf4j
@RestController
@RequestMapping("/films")
public class FilmEndpoint {

    private final FilmService filmService;
    private final FileService fileService;

    @Value("${project.image}")
    private String path;

    public FilmEndpoint(FilmService filmService, FileService fileService) {
        this.filmService = filmService;
        this.fileService = fileService;
    }

    // create film
    @PreAuthorize("hasRole('ADMIN')")
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
    public ResponseEntity<FilmResponse> readAllFilms(
            @RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir
    ) {
        FilmResponse response = filmService.readAllFilms(pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // read specific film
    @GetMapping("read/{filmId}")
    public ResponseEntity<FilmModel> readFilm(@PathVariable("filmId") int filmId) {
        FilmModel film = filmService.readFilm(filmId);
        return new ResponseEntity<>(film, HttpStatus.OK);

    }

    // update film
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update/{filmId}")
    public ResponseEntity<FilmModel> updateFilm(@RequestBody FilmModel film, @PathVariable("filmId") int filmId) {
        FilmModel updated = filmService.updateFilm(film, filmId);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // delete film
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public ApiResponse deleteFilm(@PathVariable("id") int filmId) {
        filmService.deleteFilm(filmId);
        return new ApiResponse("Film deleted successfully.", true);
    }

    // search film
    @GetMapping("/search/{keywords}")
    public ResponseEntity<List<FilmModel>> searchFilm(@PathVariable("keywords") String keywords){
        List<FilmModel> result = filmService.searchFilms(keywords);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // file image upload
    @PostMapping("/image/upload/{id}")
    public ResponseEntity<FilmModel> uploadImage(@RequestParam("image") MultipartFile image,
                                                 @PathVariable("id") int filmId) throws IOException {

        FilmModel filmModel = filmService.readFilm(filmId);
        String fileName = fileService.uploadImage(path, image);
        filmModel.setThumbnailSrc(fileName);
        FilmModel updateFilm = filmService.updateFilm(filmModel, filmId);
        return new ResponseEntity<>(updateFilm, HttpStatus.OK);
    }

    // method to serve file
    @GetMapping("/image/{thumbnailSrc}")
    public void downloadImage(@PathVariable("thumbnailSrc") String imageName,
                              HttpServletResponse response) throws IOException {
        try {
            InputStream resource = fileService.getResource(path, imageName);
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(resource, response.getOutputStream());
        } catch (FileNotFoundException e) {
            log.warn("File {}", imageName);
        }

    }
}
