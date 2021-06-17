package com.signalforce.task.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.signalforce.task.model.SalCustomer;
import com.signalforce.task.repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customers")
@RestController
public class CustomerController {

	@Autowired
	CustomerRepository repository;

	@GetMapping("")
	public ResponseEntity<List<SalCustomer>> getAllCustomers() {
		try {
			List<SalCustomer> customers = new ArrayList<SalCustomer>();

			repository.findAll().forEach(customers::add);

			if (customers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(customers, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/:id")
	public ResponseEntity<List<SalCustomer>> getById() {
		try {
			List<SalCustomer> tutorials = new ArrayList<SalCustomer>();

			repository.findAll().forEach(tutorials::add);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/lool")
	public String getCustom() {
		return "loooool";
	}

}