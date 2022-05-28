package com.example.demo.api;

import java.util.Date;

import org.springframework.hateoas.RepresentationModel;

import com.example.demo.entity.BookedRoom;
import com.example.demo.entity.Booking;

import lombok.Getter;

public class BookedRoomResource extends RepresentationModel<BookedRoomResource> {
	@Getter
	private Date checkin;
	
	@Getter
	private Date checkout;
	
	@Getter
	private Float price;
	
	@Getter
	private boolean isCheckin;
	
	@Getter
	private Float selloff;
	
	public BookedRoomResource(BookedRoom bookedRoom) {
		this.checkin = bookedRoom.getCheckin();
		this.checkout = bookedRoom.getCheckout();
		this.price = bookedRoom.getPrice();
		this.isCheckin = bookedRoom.getIsCheckin();
		this.selloff = bookedRoom.getSelloff();
	}
}
