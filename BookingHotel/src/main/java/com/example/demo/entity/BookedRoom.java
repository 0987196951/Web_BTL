package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class BookedRoom implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private Date checkin;
	
	@NotNull
	private Date checkout;
	
	@NotNull
	private Float price;
	
	@NotNull
	private Boolean isCheckin;
	
	private Float selloff;
	
	@ManyToOne
	@JoinColumn(name="bookingId")
	Booking booking;
	
	@ManyToOne
	@JoinColumn(name="roomId")
	Room room;
	
}
