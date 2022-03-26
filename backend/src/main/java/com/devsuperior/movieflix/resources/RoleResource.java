package com.devsuperior.movieflix.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.entities.Role;
import com.devsuperior.movieflix.services.RoleService;

	@RestController
	@RequestMapping(value = "/roles")
	public class RoleResource {
		
		@Autowired
		public RoleService service;
		
		@GetMapping
		public ResponseEntity<List<Role>> findAll() {
			List<Role> list = service.findAll();
			return ResponseEntity.ok().body(list);
		}
	}

