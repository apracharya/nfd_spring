package com.teamfilm.mynfd.service.review;

public interface ReviewService {
    ReviewModel createReview(ReviewModel review, int filmId, String username);
    void deleteReview(int reviewId);
}
