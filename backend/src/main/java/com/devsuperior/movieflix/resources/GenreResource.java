package com.devsuperior.movieflix.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.entities.Genre;


@RestController
@RequestMapping(value = "/genres")
public class GenreResource {
	
	@GetMapping
	public ResponseEntity<List<Genre>> findAll() {
		List<Genre> list = new ArrayList<>();
		list.add(new Genre(1L, "Terror"));
		list.add(new Genre(2L, "Romance"));
		return ResponseEntity.ok().body(list);
	}
}
