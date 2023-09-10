package com.mkstower.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mkstower.entity.limits.RoleFieldLimits;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "role")
public class Role implements RoleFieldLimits {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "name", nullable = false, length = NAME_DB_LENGTH)
	private String name;
	@Column(name = "description", length = DESCRIPTION_DB_LENGTH)
	private String description;	
	
//	@ManyToMany(mappedBy = "roles")
//	@JsonIgnoreProperties("roles")
//	private List<User> users = new ArrayList<>();
}
