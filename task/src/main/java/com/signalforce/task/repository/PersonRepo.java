package com.signalforce.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.signalforce.task.model.SalCustomerPerson;

public interface PersonRepo extends JpaRepository<SalCustomerPerson, Long> {

}
