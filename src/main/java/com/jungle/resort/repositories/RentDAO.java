package com.jungle.resort.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.jungle.resort.domain.Rent;

@Repository
public interface RentDAO extends CrudRepository <Rent, Integer>{

}
