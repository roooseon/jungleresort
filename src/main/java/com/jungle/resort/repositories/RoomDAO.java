package com.jungle.resort.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jungle.resort.domain.Room;

@Repository
public interface RoomDAO extends CrudRepository<Room, Integer>{

}
