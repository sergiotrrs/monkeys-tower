package com.mkstower.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mkstower.entity.compositekey.OrderProductKey;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "order_has_products")
public class OrderHasProduct implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderProductKey id;
	
	@ManyToOne
	@MapsId("orderId")
    @JoinColumn(name = "order_id")
	@JsonIgnoreProperties("orderHasProduct")
	private Order order;
	
	@ManyToOne
	@MapsId("productId")
    @JoinColumn(name = "product_id")
	@JsonIgnoreProperties("categories")
	private Product product;
	
	@Column(name = "quantity")
	private Long quantity;
	
	@Column(name = "price")
	private Double price;
	
}
