package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.ManagerRepository;

@RestController
@RequestMapping(path="/manager", produces = "application/json")
public class ManagerController {
	private ManagerRepository managerRepository;
	private
}
