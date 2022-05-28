package com.example.demo.entity;

import java.util.Date;

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
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private Date paymentDate;
	
	@NotNull
	private Float amount;
	
	@NotNull
	private String patymentType;

	private String note;
	
	@ManyToOne
	@MapsId("bookingId")
	@JoinColumns({
		@JoinColumn(name="userId"),
		@JoinColumn(name="managerId"),
		@JoinColumn(name="bookingId")
	})
	Booking booking;
}
