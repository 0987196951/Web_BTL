package com.example.demo.api;

import java.util.Date;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;

import com.example.demo.entity.Booking;

import lombok.Getter;

public class BookingResource extends RepresentationModel<BookingResource>{
	private static final BillResourceAssembler BILL_RESOURCE_ASSEMBLER  = new BillResourceAssembler(); 
	private static final BookedRoomResourceAssembler BOOKED_ROOM_RESOURCE_ASSEMBLER = new BookedRoomResourceAssembler();
	@Getter
	private Date bookingDate; 
	
	@Getter
	private Float selloff;
	
	@Getter
	private String note;
	
	@Getter
	private CollectionModel<BillResource> bills;
	
	@Getter
	private CollectionModel<BookedRoomResource> bookedRooms;
	
	public BookingResource(Booking booking) {
		this.bookingDate = booking.getBookingDate();
		this.selloff = booking.getSelloff();
		this.note = booking.getNote();
		this.bills = BILL_RESOURCE_ASSEMBLER.toCollectionModel(booking.getBills());
		this.bookedRooms = BOOKED_ROOM_RESOURCE_ASSEMBLER.toCollectionModel(booking.getBookedRooms());
	}
}
