package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Room implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String type;
	
	@NotNull
	private Float price;
	
	private String description;
	
	@ManyToOne
	@MapsId("hotelId")
	@JoinColumn(name="hotelId")
	Hotel hotel;
	
	@OneToMany
	@MapsId("roomId")
	private List<BookedRoom> bookedRooms = new ArrayList<>();
	
	@OneToMany
	@MapsId("roomIdPicture")
	private List<PictureRoom> pictures = new ArrayList<>();
	
	@OneToMany
	@MapsId("roomIdService")
	private List<Service> services = new ArrayList<>();
}
