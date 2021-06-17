package com.signalforce.task.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.signalforce.task.model.SalCustomerPerson;
import com.signalforce.task.repository.PersonRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/persons")
@RestController
public class PersonController {

	@Autowired
	PersonRepo repository;

	@GetMapping("")
	public ResponseEntity<List<SalCustomerPerson>> getAllPersons() {
		try {
			List<SalCustomerPerson> persons = new ArrayList<SalCustomerPerson>();

			repository.findAll().forEach(persons::add);

			if (persons.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(persons, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "", consumes = "application/json", produces = "application/json")
	private ResponseEntity<SalCustomerPerson> addPerson(@RequestBody SalCustomerPerson person) {
		try {
			repository.save(person);

			if (person == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(person, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(path = "", consumes = "application/json", produces = "application/json")
	private ResponseEntity<SalCustomerPerson> UpdatePerson(@RequestBody SalCustomerPerson person) {
		try {
			repository.findById(person.getPersonId());

			if (repository.existsById(person.getPersonId())) {
				repository.save(person);
				return new ResponseEntity<>(person, HttpStatus.OK);
			}

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		// ...
		repository.deleteById(id);
	}

//	@DeleteMapping("/{id}")
//	private ResponseEntity<SalCustomerPerson> addPerson(@PathVariable("personid") long id) {
//		try {
//			repository.deleteById(id);
//
//			return new ResponseEntity<>(HttpStatus.OK);
//		} catch (Exception e) {
//			System.out.println(e);
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	@GetMapping("/{personid}")
	public ResponseEntity<SalCustomerPerson> getById(@PathVariable("personid") long personId) {
		try {

			Optional<SalCustomerPerson> person = repository.findById(personId);

			return new ResponseEntity<SalCustomerPerson>(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
