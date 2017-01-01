package com.jungle.resort.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jungle.resort.domain.Room;

@Repository
public interface RoomDAO extends CrudRepository<Room, Integer>{
	
	@Query("FROM Room r WHERE r.roomNo= :roomNo")
	public List<Room> findRoomByNumber(@Param("roomNo") Integer roomNo);

}
