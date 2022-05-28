package com.example.demo.api;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;

public class BillResource extends RepresentationModel<BillResource> {
	@Getter
	private String name;
	
	@Getter 
	private Date 
}
