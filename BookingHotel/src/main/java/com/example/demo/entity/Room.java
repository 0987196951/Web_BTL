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
	/**
	 * 
	 */
	private static final long serialVersionUID = 7610500907207411073L;

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
	
	
	@OneToMany
	private List<BookedRoom> bookedRooms = new ArrayList<>();
	
	@OneToMany
	private List<PictureRoom> pictures = new ArrayList<>();
	
	@OneToMany
	private List<Service> services = new ArrayList<>();
}
