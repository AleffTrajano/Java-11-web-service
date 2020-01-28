package com.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.entities.Pedidos;
import com.curso.services.PedidosService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidosResource {

			
	@Autowired
	private PedidosService service;
	
	@GetMapping
	public ResponseEntity <List<Pedidos>> findAll(){
		List<Pedidos> list =  service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity <Pedidos> findById(@PathVariable Long id){
		Pedidos obj = service.findById(id);
		return   ResponseEntity.ok().body(obj);
		
		
		
		
	}
}
