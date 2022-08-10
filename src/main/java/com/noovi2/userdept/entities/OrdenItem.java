package com.noovi2.userdept.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.noovi2.userdept.entities.pk.OrderItemPk;

@Entity
@Table(name = "tb_order_item")
public class OrdenItem implements Serializable {

	private static final long serialVersionUID = 1L;

	// não colocar o @id pois vamos usar outro passo pois correlaciona bases

	@EmbeddedId
	private OrderItemPk id = new OrderItemPk();
	
	
	private Integer quantity;
	private Double price;

	public OrdenItem() {

	}

	public OrdenItem(Order order, Product product, Integer quantity, Double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}

//informando meu pedido atraves do id e jogando dentro da estrutura PK
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	
	public Product getProduct() {
		return id.getProduct();
	}

//informando meu produto atraves do id e jogando dentro da estrutura PK
	public void setOrder(Product product) {
		id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	public double getSubTotal() {
		return price*quantity;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdenItem other = (OrdenItem) obj;
		return Objects.equals(id, other.id);
	}

}
