package com.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.entities.Categorias;
import com.curso.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

			
	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public ResponseEntity <List<Categorias>> findAll(){
		List<Categorias> list =  service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity <Categorias> findById(@PathVariable Long id){
		Categorias obj = service.findById(id);
		return   ResponseEntity.ok().body(obj);
		
		
		
		
	}
}
