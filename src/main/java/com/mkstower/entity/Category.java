package com.mkstower.entity;

import java.io.Serializable;

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
public class Category implements CategoryFieldLimits, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "name", nullable = false, length = NAME_DB_LENGTH)
	private String name;
	@Column(name = "description", length = DESCRIPTION_DB_LENGTH)
	private String description;
	
}
