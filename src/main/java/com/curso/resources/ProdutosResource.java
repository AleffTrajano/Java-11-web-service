package com.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.entities.Produtos;
import com.curso.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutosResource {

			
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity <List<Produtos>> findAll(){
		List<Produtos> list =  service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity <Produtos> findById(@PathVariable Long id){
		Produtos obj = service.findById(id);
		return   ResponseEntity.ok().body(obj);
		
		
		
		
	}
}
