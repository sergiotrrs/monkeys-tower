package com.mkstower.service;

import java.util.List;

import com.mkstower.dto.UserDto;
import com.mkstower.entity.limits.UserFieldLimits;

public interface UserDtoService extends UserFieldLimits {

	UserDto createUserDto(UserDto userDto);
	
	UserDto getUserDtoById(long id);

	UserDto getUserDtoByIdAndAddressActive(long id);

	UserDto getUserDtoByEmail(String email);
	
	List<UserDto> getAllUsersDto();
	
	List<UserDto> getAllActiveUsersDto();
	
	List<UserDto> getAllInactiveUsersDto();
	
	UserDto updateUserDto(UserDto user, long id);
	
	void deleteUserDto(long id);
	
}
