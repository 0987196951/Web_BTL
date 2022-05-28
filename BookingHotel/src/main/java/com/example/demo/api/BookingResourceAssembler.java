package com.example.demo.api;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import com.example.demo.entity.Booking;
import com.example.demo.web.BookingController;

public class BookingResourceAssembler extends RepresentationModelAssemblerSupport<Booking, BookingResource> {

	public BookingResourceAssembler() {
		super(BookingController.class, BookingResource.class);
	}
	@Override
	public BookingResource toModel(Booking booking) {
		return createModelWithId(booking.getId(), booking);
	}
	@Override
	public BookingResource instantiateModel(Booking booking) {
		return new BookingResource(booking);
	}
	public CollectionModel<BookingResource> toCollectionModel(Iterable<? extends Booking> entities){
		return super.toCollectionModel(entities);
	}

}
