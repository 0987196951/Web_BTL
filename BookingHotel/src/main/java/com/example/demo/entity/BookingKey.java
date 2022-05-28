package com.example.demo.entity;	

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookingKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "userId")
	Long userId;
	@Column(name ="managerId")
	Long managerId;
}
