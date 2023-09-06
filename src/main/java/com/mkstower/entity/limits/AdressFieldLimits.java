package com.mkstower.entity.limits;

/**
 * 
 * MIN_LENGTH: Minimum number of characters for the field.
 * MAX_LENGTH: Maximum number of characters for the field.
 * DB_LENGTH: Maximum number of characters allowed for inserting into the database. 
 * @author SMTS
 *
 */
public interface AdressFieldLimits {
	int STREET_MIN_LENGTH = 2;
	int STREET_MAX_LENGTH = 150;
	int STREET_DB_LENGTH = 150;
	
	int CITY_MIN_LENGTH = 2;
	int CITY_MAX_LENGTH = 80;
	int CITY_DB_LENGTH = 80;
	
	int POSTALCODE_MIN_LENGTH = 1;
	int POSTALCODE_MAX_LENGTH = 45;
	int POSTALCODE_DB_LENGTH = 45;
		

}
