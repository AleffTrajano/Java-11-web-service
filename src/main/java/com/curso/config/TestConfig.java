package com.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso.entities.Categorias;
import com.curso.entities.Pedidos;
import com.curso.entities.Usuarios;
import com.curso.entities.enums.PedidoStatus;
import com.curso.repositories.CategoriaRepository;
import com.curso.repositories.PedidosRepository;
import com.curso.repositories.UsuariosRepository;

@Configuration
@Profile("test")
// CommandLineRunner essa interface executar tudo que esta no run ao iniciar app
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Autowired
	private  PedidosRepository pedidosRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Usuarios u1 = new Usuarios(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuarios u2 = new Usuarios(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Pedidos o1 = new Pedidos(null, Instant.parse("2019-06-20T19:53:07Z"),u1, PedidoStatus.PAGO);
		Pedidos o2 = new Pedidos(null, Instant.parse("2019-07-21T03:42:10Z"),u2, PedidoStatus.AGUARDANDO_PAGAMENTO);
		Pedidos o3 = new Pedidos(null, Instant.parse("2019-07-22T15:21:22Z"),u2, PedidoStatus.AGUARDANDO_PAGAMENTO);
		
		Categorias cat1 = new Categorias(null, "Electronics"); 
		Categorias cat2 = new Categorias(null, "Books");
		Categorias cat3 = new Categorias(null, "Computers"); 
		
		usuariosRepository.saveAll(Arrays.asList(u1,u2));
		pedidosRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
	}
	

}
