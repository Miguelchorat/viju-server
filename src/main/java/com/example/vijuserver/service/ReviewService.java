package com.example.vijuserver.service;

import com.example.vijuserver.model.Review;
import com.example.vijuserver.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> findAll(){
        return reviewRepository.findAll();
    }
    public Optional<Review> findById(Long id){
        return reviewRepository.findById(id);
    }
    public Review save(Review review){
        review.setCreated_at(LocalDateTime.now());
        review.setUpdated_at(LocalDateTime.now());
        return reviewRepository.save(review);
    }
    public Review modify(Review review){
        review.setUpdated_at(LocalDateTime.now());
        return reviewRepository.save(review);
    }
    public void deleteById(Long id){
        reviewRepository.deleteById(id);
    }
}
