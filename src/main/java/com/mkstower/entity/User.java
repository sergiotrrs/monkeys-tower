package com.mkstower.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mkstower.entity.limits.UserFieldLimits;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user")
public class User implements UserFieldLimits, Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	//@GeneratedValue
	//@Column(name = "id")
	//private UUID id;
	@Column(name = "first_name", nullable = false, length = FIRSTNAME_DB_LENGTH)
	private String firstname;
	@Column(name = "last_name", length = LASTNAME_DB_LENGTH)
	private String lastname;
	@Column(name = "email", nullable = false, updatable = false, unique = true, length = EMAIL_DB_LENGTH)
	private String email;
	@Column(name = "password", nullable = false, length = PASSWORD_DB_LENGTH)
	private String password;
	@Column(name = "avatar", length = AVATAR_DB_LENGTH)
	private String avatar;
	@Column(name = "born_at")
	private Timestamp bornAt;
	@Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	private Timestamp createdAt;
	@Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp updatedAt;
	@Column(name = "active")
	private boolean active;
	
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER,  cascade = CascadeType.MERGE)
	@JsonIgnoreProperties("user")
	private List<Address> addresses = new ArrayList<>();

//	@OneToMany(mappedBy = "user")
//	private List<Order> orders = new ArrayList<>();
//	
	@ManyToMany
	@JoinTable(
			  name = "user_has_roles", 
			  joinColumns = @JoinColumn(name = "user_id"), 
			  inverseJoinColumns = @JoinColumn(name = "role_id"))
	//@JsonIgnoreProperties("users")
	private List<Role> roles = new ArrayList<>();

}
