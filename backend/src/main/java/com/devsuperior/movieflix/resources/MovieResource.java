package com.devsuperior.movieflix.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.services.MovieService;


@RestController
@RequestMapping(value = "/movies")
public class MovieResource {
	
	@Autowired
	public MovieService service;
	
	@GetMapping
	public ResponseEntity<List<MovieDTO>> findAll() {
		List<MovieDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
		MovieDTO movie = service.findById(id);
		return ResponseEntity.ok().body(movie);
	}
}
	

