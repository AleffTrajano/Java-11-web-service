package com.curso.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.curso.entities.pk.PedidoItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@NoArgsConstructor
@Entity
@Table(name = "tb_pedido_item")
public class PedidoItens implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedidoItemPk id = new PedidoItemPk();
	
	@Setter
	@Getter
	private Integer quantidade;
	@Setter
	@Getter
	private Double preco;

	public PedidoItens(Pedidos pedidos,Produtos produtos,Integer quantidade, Double preco) {
		super();
		id.setPedido(pedidos);
		id.setProduto(produtos);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	
	@JsonIgnore
	public Pedidos getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedidos pedidos) {
		id.setPedido(pedidos);
	}
	
	
	public Produtos getProdutos() {
		return id.getProduto();
	}
	
	public void setProdutos(Produtos produtos) {
		id.setProduto(produtos);
	}

	public Double getSubTotal() {
		return preco * quantidade;
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
		PedidoItens other = (PedidoItens) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
