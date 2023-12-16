package com.agenciadeviagens.services;

import java.util.List;

import com.agenciadeviagens.models.Travel;


public interface TravelService {

List<Travel> getAllTravels();
	
	Travel getTravelById(Long id);
	
	Travel saveTravel(Travel travel);
	
	Travel updateTravel(Long id, Travel travelUpdated);
	
	void deleteById(Long id);
	
}
