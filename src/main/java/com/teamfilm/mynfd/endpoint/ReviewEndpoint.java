package com.teamfilm.mynfd.endpoint;

import com.teamfilm.mynfd.response.ApiResponse;
import com.teamfilm.mynfd.service.review.ReviewModel;
import com.teamfilm.mynfd.service.review.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/reviews")
public class ReviewEndpoint {
    private final ReviewService reviewService;

    public ReviewEndpoint(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/film/{filmId}/user/{userId}")
    public ResponseEntity<ReviewModel> createReview(@RequestBody ReviewModel review,
                                                    @PathVariable("filmId") int filmId,
                                                    @PathVariable("userId") String userId) {
        ReviewModel reviewEntity = reviewService.createReview(review, filmId, userId);
        return new ResponseEntity<>(reviewEntity, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{reviewId}")
    public ResponseEntity<ApiResponse> deleteReview(@PathVariable("reviewId") int reviewId) {
        reviewService.deleteReview(reviewId);
        return new ResponseEntity<>(new ApiResponse("Review deleted.", true), HttpStatus.OK);
    }

}
