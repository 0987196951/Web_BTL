package com.example.demo.web;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.BookingResource;
import com.example.demo.api.BookingResourceAssembler;
import com.example.demo.data.BookedRoomRepository;
import com.example.demo.data.BookingRepository;
import com.example.demo.data.UserRepository;
import com.example.demo.entity.Booking;
import com.example.demo.entity.User;

@RestController
@RequestMapping(path = "book", produces = "application/json")
@CrossOrigin("*")
public class BookingController {
	private final EntityManagerFactory ef;
	private final UserRepository userRepo;
	private final BookingRepository bookingRepo;
	private final BookedRoomRepository bookedRepo;
	@Autowired
	public BookingController(BookingRepository bookingRepo, BookedRoomRepository bookedRepo, UserRepository userRepo, EntityManagerFactory e) {
		this.bookedRepo = bookedRepo;
		this.bookingRepo = bookingRepo;
		this.userRepo = userRepo;
		this.ef = e;
	}
	
	@GetMapping(path = "/{userId}", produces = "application/hal+json")
	public ResponseEntity<CollectionModel<BookingResource>> bookingOfUser(@PathVariable Long userId){
		//PageRequest pageRequest = PageRequest.of(0, 12, Sort.by("paymentDay").descending());
		Optional<User> useropt = userRepo.findById(userId);
		if(useropt.isPresent()) {
			List<Booking> bookings = useropt.get().getBookings();
			CollectionModel<BookingResource> bookingsResource = new BookingResourceAssembler().toCollectionModel(bookings);
			bookingsResource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookingController.class
					).bookingOfUser(userId)).withRel("booking"));
			return new ResponseEntity<>(bookingsResource, HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
}
	
}
