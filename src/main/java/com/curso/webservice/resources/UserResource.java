package com.curso.webservice.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.webservice.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	
			
			
	@GetMapping
	public ResponseEntity <User> findAll(){
		User u = new User(1L, "Aleff", "Aleff_diniz@hotmail.com", "998690562", "123");
		return ResponseEntity.ok().body(u);
	}
}
