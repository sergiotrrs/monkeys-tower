package com.mkstower.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mkstower.entity.limits.AdressFieldLimits;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "address")
public class Address implements AdressFieldLimits, Serializable {

	private static final long serialVersionUID = 1L;
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
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE )
	//@JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnoreProperties("addresses")
	private User user;
	
}
