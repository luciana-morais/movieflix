package com.devsuperior.movieflix.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.services.MovieService;


@RestController
@RequestMapping(value = "/movies")
public class MovieResource {
	
	@Autowired
	public MovieService service;
	
	@GetMapping
	public ResponseEntity<List<Movie>> findAll() {
		List<Movie> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	}
	

