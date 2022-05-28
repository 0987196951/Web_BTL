package com.example.demo.api;

import java.util.Date;

import org.springframework.hateoas.RepresentationModel;

import com.example.demo.entity.Bill;

import lombok.Getter;

public class BillResource extends RepresentationModel<BillResource> {
	@Getter
	private String name;
	
	@Getter 
	private Date paymentDate;
	
	@Getter
	private Float amount;
	
	@Getter
	private String paymentType;
	
	@Getter
	private String note;
	
	public BillResource(Bill bill) {
		this.name = name;
		this.amount = amount;
		this.note = note;
		this.paymentDate = paymentDate;
		this.paymentType = paymentType;
	}
}
