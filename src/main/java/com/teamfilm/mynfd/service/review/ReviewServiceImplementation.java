package com.teamfilm.mynfd.service.review;

import com.teamfilm.mynfd.exception.NotFoundException;
import com.teamfilm.mynfd.exception.ResourceNotFoundException;
import com.teamfilm.mynfd.persistence.film.FilmEntity;
import com.teamfilm.mynfd.persistence.film.FilmRepository;
import com.teamfilm.mynfd.persistence.review.ReviewEntity;
import com.teamfilm.mynfd.persistence.review.ReviewRepository;
import com.teamfilm.mynfd.persistence.user.UserEntity;
import com.teamfilm.mynfd.persistence.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ReviewServiceImplementation implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final FilmRepository filmRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public ReviewServiceImplementation(ReviewRepository reviewRepository, FilmRepository filmRepository,
                                       ModelMapper modelMapper, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.filmRepository = filmRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public ReviewModel createReview(ReviewModel review, int filmId, String username) {

        FilmEntity film = filmRepository.findById(filmId)
                .orElseThrow(()-> new ResourceNotFoundException("Film", "with id", filmId));
        UserEntity user = userRepository.findById(username)
                .orElseThrow(NotFoundException::new);
        ReviewEntity reviewentity = modelMapper.map(review, ReviewEntity.class);
        reviewentity.setFilm(film);
        reviewentity.setUser(user);

        ReviewEntity createdReview = reviewRepository.save(reviewentity);
        return modelMapper.map(createdReview, ReviewModel.class);
    }

    @Override
    public ReviewModel readReview(int reviewId) {
        ReviewEntity entity = reviewRepository.findById(reviewId)
                .orElseThrow(()-> new ResourceNotFoundException("Review", "with id", reviewId));
        return modelMapper.map(entity, ReviewModel.class);
    }

    @Override
    public ReviewModel updateReview(ReviewModel review, int reviewId) {
        ReviewEntity reviewEntity = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review", "with id", reviewId));
        reviewEntity.setBody(review.getBody());
        reviewEntity.setRating(review.getRating());
        ReviewEntity updated = reviewRepository.save(reviewEntity);
        return modelMapper.map(updated, ReviewModel.class);
    }

    @Override
    public void deleteReview(int reviewId) {
        ReviewEntity review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ResourceNotFoundException("Review", "with id", reviewId));
        reviewRepository.delete(review);
    }
}
