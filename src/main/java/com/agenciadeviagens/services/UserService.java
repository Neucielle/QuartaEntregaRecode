package com.agenciadeviagens.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agenciadeviagens.dto.UserDTO;
import com.agenciadeviagens.models.User;


@Service
public interface UserService {

List<User> getAllUsers();
	
	User getUserById(Long id);
	
	User saveUser(UserDTO userDTO);
	
	User updateUser(Long id, UserDTO userDTOUpdated);
	
	void deleteById(Long id);
	
	void addRelationship(Long userId, Long travelId);
	
	List<Object> findAllRels();
}
