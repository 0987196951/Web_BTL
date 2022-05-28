package com.example.demo.api;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import com.example.demo.entity.Room;
import com.example.demo.web.RoomController;

public class RoomResourceAssembler extends RepresentationModelAssemblerSupport<Room, RoomResource> {

	public RoomResourceAssembler() {
		super(RoomController.class, RoomResource.class);
		// TODO Auto-generated constructor stub
	}
	@Override
	public RoomResource toModel(Room room) {
		return createModelWithId(room.getId(), room);
	}
	@Override 
	protected RoomResource instantiateModel(Room room) {
		return new RoomResource(room);
	}
	public CollectionModel<RoomResource> toCollectionModel(Iterable<? extends Room> entities){
		return super.toCollectionModel(entities);
	}
}
