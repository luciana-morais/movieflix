package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.EntityNotFoundException;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;

	@Transactional(readOnly = true)
	public List<ReviewDTO> findAll() {
		List<Review> reviews = repository.findAll();
		return reviews.stream().map(review -> new ReviewDTO(review)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ReviewDTO findById(Long id) {
		Optional<Review> obj = repository.findById(id);
		Review entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found."));
		return new ReviewDTO(entity);
	}
}
