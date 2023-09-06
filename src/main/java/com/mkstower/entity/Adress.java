package com.mkstower.entity;

import com.mkstower.entity.limits.AdressFieldLimits;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "adress")
public class Adress implements AdressFieldLimits {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "street", nullable = false, length = STREET_DB_LENGTH)
	private String street;
	@Column(name = "city", length = CITY_DB_LENGTH)
	private String city;	
	@Column(name = "postalcode", length = POSTALCODE_DB_LENGTH)
	private String postalCode;
	@Column(name = "active")
	private boolean active;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
	private User user;
	
}
