package com.curso.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.curso.entities.enums.PedidoStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Entity
@Table(name = "tb_pedidos")
public class Pedidos implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Setter
	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Setter
	@Getter
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;

	@Setter
	private Integer pedidoStatus;

	@Setter
	@Getter
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuarios client;
	
	@Setter
	@Getter
	@OneToMany(mappedBy = "id.pedido")
	private Set<PedidoItens> itens = new HashSet<>();
	
	@Setter
	@Getter
	@OneToOne(mappedBy ="pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	

	public Pedidos(Long id, Instant instant, Usuarios client,PedidoStatus pedidoStatus) {
		super();
		this.id = id;
		this.moment = instant;
		this.client = client;
		setPedidoStatus(pedidoStatus);
	}
	
	public PedidoStatus getPedidoStatus() {
		return PedidoStatus.valueOf(pedidoStatus);
	}
	
	public void setPedidoStatus(PedidoStatus pedidoStatus) {
		if(pedidoStatus != null)
		this.pedidoStatus = pedidoStatus.getCode();
	}
	
	
	public Double getTotal() {
		double sum = 0.0;
		for (PedidoItens item : itens) {
			sum += item.getSubTotal();
		}
		return sum;
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
		Pedidos other = (Pedidos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
