package com.example.demo.api;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import com.example.demo.entity.Bill;
import com.example.demo.web.BillController;

public class BillResourceAssembler extends RepresentationModelAssemblerSupport<Bill, BillResource> {

	public BillResourceAssembler() {
		super(BillController.class, BillResource.class);
	}
	@Override
	public BillResource toModel(Bill bill) {
		return createModelWithId(bill.getId(), bill);
	}
	@Override
	public BillResource instantiateModel(Bill bill) {
		return new BillResource(bill);
	}
	public CollectionModel<BillResource> toCollectionModel(Iterable<? extends Bill> entities){
		return super.toCollectionModel(entities);
	}
}
