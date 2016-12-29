package com.jungle.resort.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jungle.resort.domain.Customer;

@Repository
public interface CustomerDAO extends CrudRepository<Customer, Integer>{

}
