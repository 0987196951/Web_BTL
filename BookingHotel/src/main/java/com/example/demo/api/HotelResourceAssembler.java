package com.example.demo.api;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import com.example.demo.entity.Hotel;
import com.example.demo.web.HotelController;

public class HotelResourceAssembler extends RepresentationModelAssemblerSupport<Hotel, HotelResource> {

	public HotelResourceAssembler() {
		super(HotelController.class, HotelResource.class);
		// TODO Auto-generated constructor stub
	}
	@Override
	public HotelResource toModel( Hotel entity) {
		return createModelWithId(entity.getId(), entity);
	}
	@Override 
	public HotelResource instantiateModel(Hotel hotel) {
		return new HotelResource(hotel);
	}
	public CollectionModel<HotelResource> toColllectionModel(Iterable<? extends Hotel> entities){
		return super.toCollectionModel(entities);
	}
}
