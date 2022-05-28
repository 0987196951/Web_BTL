package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Data
@Entity
public class Hotel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private String name;
	
	@NotNull
	private String address;
	
	@NotNull
	private Long starLevel;
	
	private String description;
	
	@OneToMany
	private List<Room> rooms = new ArrayList<>();
	
	@OneToMany
	private List<PictureHotel> pictures = new ArrayList<>();
}
