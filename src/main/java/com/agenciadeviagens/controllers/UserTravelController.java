package com.agenciadeviagens.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenciadeviagens.dto.UserTravelDTO;
import com.agenciadeviagens.services.UserService;




@RestController
@RequestMapping("/userreltravel")
public class UserTravelController {

	@Autowired
	private UserService usr;
	
	
	
	@PostMapping("/addusertravel")
	public ResponseEntity<String> addRelationship(@RequestBody UserTravelDTO usrDTO){
		usr.addRelationship(usrDTO.getUserId(), usrDTO.getTravelId());
		
		
		return new ResponseEntity<>("Relatioship created", HttpStatus.CREATED);
		
		
	}
	
	
	
	@GetMapping("/findallrels")
	public List<Object> getAllRels(){
		
		
		return usr.findAllRels();
	}
	
	
}
