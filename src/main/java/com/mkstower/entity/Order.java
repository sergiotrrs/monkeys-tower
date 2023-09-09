package com.mkstower.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
	
//	@ManyToOne
//    @JoinColumn(name = "user_id")
//	private User user;
//	
//	@ManyToOne
//    @JoinColumn(name = "adress_id")
//	private Address adress;
//	
//	@ManyToMany
//	@JoinTable(
//			  name = "order_has_products", 
//			  joinColumns = @JoinColumn(name = "order_id"), 
//			  inverseJoinColumns = @JoinColumn(name = "product_id"))
//	private List<Product> products = new ArrayList<>();
	

}
