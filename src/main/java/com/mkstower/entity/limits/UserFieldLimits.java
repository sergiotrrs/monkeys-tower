package com.mkstower.entity.limits;

/**
 * Customers data.
 * MIN_LENGTH: Minimum number of characters for the field.
 * MAX_LENGTH: Maximum number of characters for the field.
 * DB_LENGTH: Maximum number of characters allowed for inserting into the database. 
 * @author SMTS
 *
 */
public interface UserFieldLimits {
	int FIRSTNAME_MIN_LENGTH = 2;
	int FIRSTNAME_MAX_LENGTH = 80;
	int FIRSTNAME_DB_LENGTH = 80;
	
	int LASTNAME_MIN_LENGTH = 2;
	int LASTNAME_MAX_LENGTH = 80;
	int LASTNAME_DB_LENGTH = 80;
	
	int EMAIL_MIN_LENGTH = 2;
	int EMAIL_MAX_LENGTH = 100;
	int EMAIL_DB_LENGTH = 100;

	int PASSWORD_MIN_LENGTH = 3;
	int PASSWORD_MAX_LENGTH = 25;
	int PASSWORD_DB_LENGTH = 150;
	
	int AVATAR_MIN_LENGTH = 0;
	int AVATAR_MAX_LENGTH = 150;
	int AVATAR_DB_LENGTH = 150;
		

}
