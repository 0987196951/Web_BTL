package com.example.demo.api;

import org.springframework.hateoas.RepresentationModel;

import com.example.demo.entity.Room;

import lombok.Getter;

public class RoomResource extends RepresentationModel<RoomResource> {
	@Getter
	private String name;
	
	@Getter
	private Long type;
	
	@Getter
	private Float price;
	
	@Getter
	private String description;
	
	public RoomResource(Room room) {
		this.name = room.getName();
		this.description = room.getDescription();
		this.price = room.getPrice();
		this.type = room.getType();
	}
	
}
