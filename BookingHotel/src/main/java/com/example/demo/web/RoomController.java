package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.RoomResource;
import com.example.demo.api.RoomResourceAssembler;
import com.example.demo.data.HotelRepository;
import com.example.demo.data.RoomRepository;
import com.example.demo.entity.Hotel;
import com.example.demo.entity.Room;

@RestController
@RequestMapping(path="/rooms", produces="application/json")
public class RoomController {
	private final HotelRepository hotelRepo;
	private final RoomRepository roomRepo;
	@Autowired
	public RoomController(HotelRepository hotelRepo, RoomRepository roomRepo) {
		this.hotelRepo = hotelRepo;
		this.roomRepo = roomRepo;
	}
	@GetMapping("/get/{hotelId}")
	public ResponseEntity<CollectionModel<RoomResource>> getRoomOfHotel(@PathVariable Long hotelId){
		Optional<Hotel> hotel = hotelRepo.findById(hotelId);
		if(hotel.isPresent()) {
			List<Room> rooms = hotel.get().getRooms();
			CollectionModel<RoomResource> roomResources = new RoomResourceAssembler().toCollectionModel(rooms);
			return new ResponseEntity<>(roomResources, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
}
