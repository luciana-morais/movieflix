package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.EntityNotFoundException;

@Service
public class MovieService {


	@Autowired
	private MovieRepository repository;

	@Transactional(readOnly = true)
	public List<MovieDTO> findAll() {
		List<Movie> movies = repository.findAll();
		return movies.stream().map(movie -> new MovieDTO(movie)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Optional<Movie> obj = repository.findById(id);
		Movie entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found."));
		return new MovieDTO(entity);
	}
}
