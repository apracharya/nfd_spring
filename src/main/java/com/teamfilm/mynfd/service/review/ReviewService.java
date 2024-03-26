package com.teamfilm.mynfd.service.review;

public interface ReviewService {
    ReviewModel createReview(ReviewModel review, int filmId, String username);
    ReviewModel readReview(int reviewId);
    ReviewModel updateReview(ReviewModel review, int reviewId);
    void deleteReview(int reviewId);
}
