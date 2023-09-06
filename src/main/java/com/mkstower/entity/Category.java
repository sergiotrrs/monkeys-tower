package com.mkstower.entity;

import java.util.ArrayList;
import java.util.List;

import com.mkstower.entity.limits.CategoryFieldLimits;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "category")
public class Category implements CategoryFieldLimits {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "name", nullable = false, length = NAME_DB_LENGTH)
	private String name;
	@Column(name = "description", length = DESCRIPTION_DB_LENGTH)
	private String description;
	
	@ManyToMany(mappedBy = "categories")
	private List<Product> products = new ArrayList<>();
	
}
