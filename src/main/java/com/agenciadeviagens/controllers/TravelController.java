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

import com.agenciadeviagens.models.Travel;
import com.agenciadeviagens.services.TravelService;




@RestController
@RequestMapping("/travel")
public class TravelController {

	@Autowired
	private TravelService tr;

	@PostMapping("/savetravel")
	public Travel createtravel(@RequestBody Travel travel) {

		return tr.saveTravel(travel);
	}

	@GetMapping("/alltravels")
	public List<Travel> getAllTravels() {

		return tr.getAllTravels();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Travel> getTravelById(@PathVariable Long id) {
		Travel travel = tr.getTravelById(id);

		return ResponseEntity.ok(travel);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Travel> updateTravel(@PathVariable Long id, @RequestBody Travel travelUpdated) {
		Travel travel = tr.getTravelById(id);

		travel.setName(travelUpdated.getName());

		tr.saveTravel(travel);

		return ResponseEntity.ok(travel);
	}

	@DeleteMapping("/{id}")
	public void deleteTravel(@PathVariable Long id) {
		tr.deleteById(id);
	}

}
