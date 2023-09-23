package com.mkstower.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mkstower.entity.Address;
import com.mkstower.entity.Role;
import com.mkstower.entity.limits.UserFieldLimits;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto implements UserFieldLimits, Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	
	@NotEmpty(message = "Firstname should not be null or empty")
	@Size(min= FIRSTNAME_MIN_LENGTH, max= FIRSTNAME_MAX_LENGTH, 
			message = "Fist name must be between " + FIRSTNAME_MIN_LENGTH + " and "+ FIRSTNAME_MAX_LENGTH + " characters")
	private String firstname;

	@NotEmpty(message = "Lastname should not be null or empty")
	@Size(min= LASTNAME_MIN_LENGTH, max= LASTNAME_MAX_LENGTH, 
			message = "Last name must be between " + LASTNAME_MIN_LENGTH + " and "+ LASTNAME_MAX_LENGTH + " characters")
	private String lastname;

	@NotEmpty(message = "E-mail should not be null or empty")
	@Email(message = "Email address should be valid", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,10}")
	@Size(min= EMAIL_MIN_LENGTH, max= EMAIL_MAX_LENGTH, 
			message = "E-mail must be between " + EMAIL_MIN_LENGTH + " and "+ EMAIL_MAX_LENGTH + " characters")
	private String email;

	@Size(min= AVATAR_MIN_LENGTH, max= AVATAR_MAX_LENGTH, 
			message = "Avatar must be between " + AVATAR_MIN_LENGTH + " and "+ AVATAR_MAX_LENGTH + " characters")
	private String avatar;

	@Past( message = "Birthdate must be in the past.")
	private Timestamp birthdate;
	
	// TODO change to AdressDto
	@JsonIgnoreProperties("user")
	private List<Address> addresses = new ArrayList<>();
	
	private List<Role> roles = new ArrayList<>();
}
