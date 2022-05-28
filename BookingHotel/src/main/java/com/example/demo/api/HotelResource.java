package com.example.demo.api;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Room;

import lombok.Getter;

public class HotelResource extends RepresentationModel<HotelResource> {
	private static final RoomResourceAssembler ROOM_RESOURCE_ASSEMBLER = new RoomResourceAssembler();
	@Getter
	private String name;
	
	@Getter
	private String address;
	
	@Getter
	private String description;
	
	@Getter
	private Long starLevel;
	
	@Getter
	private CollectionModel<RoomResource> rooms;
	
	public HotelResource(Hotel hotel) {
		this.name = hotel.getName();
		this.address = hotel.getAddress();
		this.description = hotel.getDescription();
		this.starLevel = hotel.getStarLevel();
		this.rooms = ROOM_RESOURCE_ASSEMBLER.toCollectionModel(hotel.getRooms());
	}
}
