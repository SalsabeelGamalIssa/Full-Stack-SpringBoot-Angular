package com.signalforce.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.signalforce.task.model.SalCustomer;

public interface CustomerRepository extends JpaRepository<SalCustomer, Long> {

}