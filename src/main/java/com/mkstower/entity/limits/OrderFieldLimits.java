package com.mkstower.entity.limits;

/**
 * 
 * MIN_LENGTH: Minimum number of characters for the field.
 * MAX_LENGTH: Maximum number of characters for the field.
 * DB_LENGTH: Maximum number of characters allowed for inserting into the database. 
 * @author SMTS
 *
 */
public interface OrderFieldLimits {
	int NAME_MIN_LENGTH = 2;
	int NAME_MAX_LENGTH = 150;
	int NAME_DB_LENGTH = 150;
	
	int DESCRIPTION_MIN_LENGTH = 2;
	int DESCRIPTION_MAX_LENGTH = 80;
	int DESCRIPTION_DB_LENGTH = 80;
	
	int IMAGE_MIN_LENGTH = 0;
	int IMAGE_MAX_LENGTH = 150;
	int IMAGE_DB_LENGTH = 150;
		

}
