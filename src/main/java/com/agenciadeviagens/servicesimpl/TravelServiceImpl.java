package com.agenciadeviagens.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenciadeviagens.models.Travel;
import com.agenciadeviagens.repositories.TravelRepository;
import com.agenciadeviagens.services.TravelService;



@Service
public class TravelServiceImpl implements TravelService {

	@Autowired
	private TravelRepository st;

	@Override
	public List<Travel> getAllTravels() {

		return st.findAll();
	}

	@Override
	public Travel getTravelById(Long id) {

		return st.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
	}

	@Override
	public Travel saveTravel(Travel travel) {

		return st.save(travel);
	}

	@Override
	public Travel updateTravel(Long id, Travel travelUpdated) {
		Travel travelExists = st.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
		travelExists.setName(travelUpdated.getName());

		return st.save(travelExists);
	}

	@Override
	public void deleteById(Long id) {
		st.deleteById(id);

	}
}
