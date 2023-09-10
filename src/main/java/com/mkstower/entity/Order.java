package com.mkstower.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "product_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;	
	@Column(name = "purchase_date")
	private Timestamp purchaseDate;
	@Column(name = "delivery_date")
	private Timestamp deliveryDate;
	@Column(name = "total_amount")
	private double totalAmount;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
	@JsonIgnoreProperties({"addresses", "roles"})
	private User user;
	
	@ManyToOne
    @JoinColumn(name = "address_id")
	@JsonIgnoreProperties({"user"})
	private Address deliveryAddress;
	
	@ManyToMany
	@JoinTable(
			  name = "order_has_products", 
			  joinColumns = @JoinColumn(name = "order_id"), 
			  inverseJoinColumns = @JoinColumn(name = "product_id"))	
	@JsonIgnoreProperties({"categories"})
	private List<Product> products = new ArrayList<>();
	

}
