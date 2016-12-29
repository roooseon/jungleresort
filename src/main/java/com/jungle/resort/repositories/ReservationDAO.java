package com.jungle.resort.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jungle.resort.domain.Reservation;

@Repository
public interface ReservationDAO extends CrudRepository<Reservation, Integer>{

}
