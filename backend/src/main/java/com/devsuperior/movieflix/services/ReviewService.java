package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;

	@Transactional
	public List<ReviewDTO> findAll() {
		List<Review> reviews = repository.findAll();
		return reviews.stream().map(review -> new ReviewDTO(review)).collect(Collectors.toList());
	}
}
