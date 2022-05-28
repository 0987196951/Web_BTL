package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Booking implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private Date bookingDate;

	private Float selloff;
	
	private String note;
	
	@EmbeddedId
	BookingKey idKey;
	
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name="userId")
	User user;
	@ManyToOne
	@MapsId("managerId")
	@JoinColumn(name="managerId")
	Manager manager;
	@PrePersist
	void bookingDate() {
		this.bookingDate = new Date();
	}
	
	@OneToMany
	@MapsId("bookingId")
	private List<BookedRoom> bookedRooms = new ArrayList<>();
	
	@OneToMany
	@MapsId("bookingId")
	private List<Bill> bills = new ArrayList<>();
}
