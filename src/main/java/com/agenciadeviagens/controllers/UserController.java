package com.agenciadeviagens.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenciadeviagens.dto.UserDTO;
import com.agenciadeviagens.models.User;
import com.agenciadeviagens.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService usr;

	@PostMapping("/saveuser")
	public User createUser(@RequestBody UserDTO userDto) {

		return usr.saveUser(userDto);
	}

	@GetMapping("/allusers")
	public List<User> getAllUsers() {

		return usr.getAllUsers();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		User user = usr.getUserById(id);
		
		return ResponseEntity.ok(user);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTOUpdated){
		User user = usr.getUserById(id);
		
	
		
		usr.updateUser(id, userDTOUpdated);
		
		return ResponseEntity.ok(user);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		usr.deleteById(id);
	}
	
	
}
