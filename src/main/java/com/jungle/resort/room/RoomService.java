package com.jungle.resort.room;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jungle.resort.domain.Room;
import com.jungle.resort.domain.RoomStatus;
import com.jungle.resort.repositories.RoomDAO;

@Service
@Transactional
public class RoomService implements IRoomService{

	@Autowired
	private RoomDAO roomdao;
	
	@Override
	public Room addRoom(Room room) {
		return roomdao.save(room);
	}

	@Override
	public void deleteRoom(int id) {
		roomdao.delete(id);
	}

	@Override
	public Room getRoomById(int id) {
		return roomdao.findOne(id);
	}

	@Override
	public List<Room> getAllRoom() {
		return (List<Room>) roomdao.findAll();
	}

	@Override
	public List<Room> getAllAvailableRoom() {
		List<Room> allRooms=  (List<Room>) roomdao.findAll();
		List<Room> avaialbleRooms= new ArrayList<Room>();
		for(Room r: allRooms){
			if(r.getRoomStatus().equals(RoomStatus.Available)){
				avaialbleRooms.add(r);
			}
		}
		return avaialbleRooms ;
	}	
}
