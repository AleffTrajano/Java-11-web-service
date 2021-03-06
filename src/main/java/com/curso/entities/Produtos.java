package com.curso.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "tb_Produtos")
public class Produtos implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Getter
	@Setter
	private String nome;
	@Getter
	@Setter
	private String descricao;
	@Getter
	@Setter
	private String imgUrl;
	@Getter
	@Setter
	private Double preco;

	// Conjunto de categorias
	
	@Getter
	@ManyToMany
	@JoinTable(name = "tb_produtos_categoria", 
	joinColumns = @JoinColumn(name = "produto_id"),
	inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private Set<Categorias> categorias = new HashSet<>();

	@OneToMany(mappedBy = "id.produto")
	private Set<PedidoItens> items = new HashSet<>();
	
	
	
	@OneToOne(mappedBy = "pedido",cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	
	
	
	public Produtos(Long id, String nome, String descricao, String imgUrl, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.imgUrl = imgUrl;
		this.preco = preco;

	}
	
	
	@JsonIgnore
	public Set<Pedidos> getOrders(){
		Set<Pedidos> set = new HashSet<>();
		for(PedidoItens item : items) {
			set.add(item.getPedido());
		}
		return set;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produtos other = (Produtos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
