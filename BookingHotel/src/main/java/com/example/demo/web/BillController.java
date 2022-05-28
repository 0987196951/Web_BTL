package com.example.demo.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.BillResource;
import com.example.demo.data.BillRepository;
import com.example.demo.entity.Bill;

@RestController
@RequestMapping(path="bills", produces="application/json")
@CrossOrigin("*")
public class BillController {
	private BillRepository billRepo;
	@Autowired
	public BillController(BillRepository billRepo) {
		this.billRepo = billRepo;
	}
	
	@GetMapping
	public ResponseEntity<Bill> billById(@PathVariable("id") Long id){
		Optional<Bill> optBill = billRepo.findById(id);
		if(optBill.isPresent()) {
			return new ResponseEntity<>(optBill.get(), HttpStatus.OK);
		}
		else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Bill postBill(@RequestBody Bill bill ) {
		return billRepo.save(bill);
	}
	
}
