package com.agenciadeviagens.servicesimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenciadeviagens.dto.UserDTO;
import com.agenciadeviagens.models.User;
import com.agenciadeviagens.models.Travel;
import com.agenciadeviagens.repositories.TravelRepository;
import com.agenciadeviagens.repositories.UserRepository;
import com.agenciadeviagens.services.UserService;

@Service
public class UserServiceImpl implements UserService  {

	@Autowired
	private ModelMapper mp;

	@Autowired
	private UserRepository usr;
	
	@Autowired
	private TravelRepository tr;

	public List<User> getAllUsers() {
		return usr.findAll();
	}

	public User getUserById(Long id) {
		return usr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
	}

	public User saveUser(UserDTO userDTO) {
		User user = mp.map(userDTO, User.class);
		return usr.save(user);
	}

	public User updateUser(Long id, UserDTO userDTOUpdated) {
		User userExists = usr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
		userExists.setName(userDTOUpdated.getName());
		return usr.save(userExists);
	}

	public void deleteById(Long id) {
		usr.deleteById(id);
	}

	public void addRelationship(Long userId, Long travelId) {
		User user = usr.findById(userId).orElseThrow(() -> new RuntimeException("ID: " + userId + "Not Found"));
		Travel travel = tr.findById(travelId).orElseThrow(() -> new RuntimeException("ID: " + travelId + "Not Found"));
		
		if(user != null && travel != null) {
			user.getTravels().add(travel);
			travel.getUsers().add(user);
			
			usr.save(user);
			tr.save(travel);
		}
	}

	public List<Object> findAllRels() {
		return usr.findAllRels();
	}
}