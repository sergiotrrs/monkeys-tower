package com.mkstower.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mkstower.entity.limits.ProductFieldLimits;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "product")
public class Product implements ProductFieldLimits, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name", nullable = false, length = NAME_DB_LENGTH)
	private String name;
	@Column(name = "description", length = DESCRIPTION_DB_LENGTH)
	private String description;	
	@Column(name = "image", length = IMAGE_DB_LENGTH)
	private String image;
	@Column(name = "price")
	private double price;
	@Column(name = "stock")
	private int stock;
	@Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	private Timestamp createdAt;
	@Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp updatedAt;
	@Column(name = "active")
	private boolean active;
	
	@ManyToMany
	@JoinTable(
			  name = "product_has_categories", 
			  joinColumns = @JoinColumn(name = "product_id"), 
			  inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories = new ArrayList<>();


}
