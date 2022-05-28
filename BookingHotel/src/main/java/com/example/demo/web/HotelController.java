package com.example.demo.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.HotelResource;
import com.example.demo.api.HotelResourceAssembler;
import com.example.demo.data.HotelRepository;
import com.example.demo.data.ManagerRepository;
import com.example.demo.entity.Hotel;
import com.example.demo.entity.Manager;

@RestController
@RequestMapping(path = "/hotels", produces = "application/json")
public class HotelController {
	private final HotelRepository hotelRepo;
	private final ManagerRepository managerRepo;
	@Autowired
	public HotelController(HotelRepository hotelRepo,ManagerRepository managerRepo ) {
		this.hotelRepo = hotelRepo;
		this.managerRepo = managerRepo;
	}
	@GetMapping(path="/get/{mangerId}")
	public ResponseEntity<Hotel> showHotelOfManager(@PathVariable Long managerId){
		Optional<Manager> manageropt = managerRepo.findById(managerId);
		if(manageropt.isPresent()) {
				return new ResponseEntity<>(manageropt.get().getHotel(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping(path="/del/{hotelId}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteHotel(@PathVariable("hotelId") Long hotelId) {
		try {
			hotelRepo.deleteById(hotelId);
			
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}
	
	@PutMapping("/put/{hotelId}")
	public Hotel putHotel(@RequestBody Hotel hotel) {
		return hotelRepo.save(hotel);
	}
}
