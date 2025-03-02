package com.teamfilm.nfd.endpoint;

import com.teamfilm.nfd.response.ApiResponse;
import com.teamfilm.nfd.service.film.FilmModel;
import com.teamfilm.nfd.service.film.FilmService;
import com.teamfilm.nfd.service.review.ReviewModel;
import com.teamfilm.nfd.service.review.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/reviews")
public class ReviewEndpoint {
    private final ReviewService reviewService;
    private final FilmService filmService;

    public ReviewEndpoint(ReviewService reviewService, FilmService filmService) {
        this.reviewService = reviewService;
        this.filmService = filmService;
    }

    @PostMapping("/film/{filmId}/user/{userId}")
    public ResponseEntity<ReviewModel> createReview(@RequestBody ReviewModel review,
                                                    @PathVariable("filmId") int filmId,
                                                    @PathVariable("userId") String userId) {
        ReviewModel reviewEntity = reviewService.createReview(review, filmId, userId);
        FilmModel filmModel = filmService.readFilm(filmId);

//        Random random = new Random();
//        int randomNumber = random.nextInt(11) + 30; // Random number between 30 and 40

//        double rating = ( randomNumber * filmModel.getRating() + review.getRating()) / (randomNumber+1); // Ensure division results in a floating-point value

        double rating = ( 34 * filmModel.getRating() + review.getRating()) / 35.0; // Ensure division results in a floating-point value
//        double roundedRating = Math.round(rating * 10.0) / 10.0; // Round off to the nearest tenth
        filmModel.setRating(rating);

        filmService.updateFilm(filmModel, filmId);
        return new ResponseEntity<>(reviewEntity, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{reviewId}")
    public ResponseEntity<ApiResponse> deleteReview(@PathVariable("reviewId") int reviewId) {
        reviewService.deleteReview(reviewId);
        return new ResponseEntity<>(new ApiResponse("Review deleted.", true), HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewModel> readReview(@PathVariable("reviewId") int reviewId) {
        ReviewModel review = reviewService.readReview(reviewId);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PutMapping("/update/{reviewId}")
    public ResponseEntity<ReviewModel> updateReview(@RequestBody ReviewModel review, @PathVariable("reviewId") int reviewId) {
        ReviewModel reviewModel = reviewService.updateReview(review, reviewId);
        return new ResponseEntity<>(reviewModel, HttpStatus.OK);
    }

}
