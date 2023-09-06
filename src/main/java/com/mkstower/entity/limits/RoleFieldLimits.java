package com.mkstower.entity.limits;

/**
 * 
 * MIN_LENGTH: Minimum number of characters for the field.
 * MAX_LENGTH: Maximum number of characters for the field.
 * DB_LENGTH: Maximum number of characters allowed for inserting into the database. 
 * @author SMTS
 *
 */
public interface RoleFieldLimits {
	int NAME_MIN_LENGTH = 2;
	int NAME_MAX_LENGTH = 45;
	int NAME_DB_LENGTH = 45;
	
	int DESCRIPTION_MIN_LENGTH = 2;
	int DESCRIPTION_MAX_LENGTH = 200;
	int DESCRIPTION_DB_LENGTH = 200;
}
