package com.mkstower.entity;

import java.io.Serializable;
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
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
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

	@OneToMany(mappedBy = "order")
	@JsonIgnoreProperties({"order"})
	private List<OrderHasProduct> orderHasProduct = new ArrayList<>();
	

}
