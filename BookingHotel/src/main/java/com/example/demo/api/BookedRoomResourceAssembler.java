package com.example.demo.api;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.CollectionModel;
import com.example.demo.entity.BookedRoom;
import com.example.demo.web.BookingController;

public class BookedRoomResourceAssembler extends RepresentationModelAssemblerSupport<BookedRoom	, BookedRoomResource> {

	public BookedRoomResourceAssembler() {
		super(BookingController.class, BookedRoomResource.class);
	}
	@Override
	public BookedRoomResource toModel(BookedRoom entity) {
		return createModelWithId(entity.getId(), entity);
	}
	@Override
	protected BookedRoomResource instantiateModel(BookedRoom entity) {
		return new BookedRoomResource(entity);
	}
	
	public CollectionModel<BookedRoomResource> toCollectionModel(Iterable<? extends BookedRoom> entities){
		return super.toCollectionModel(entities);		
	}
	
}
