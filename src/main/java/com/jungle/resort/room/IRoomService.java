package com.jungle.resort.room;

import java.util.List;

import com.jungle.resort.domain.Room;

public interface IRoomService {
	public Room addRoom(Room room);
	public void deleteRoom(int id);
	public Room getRoomById(int id);
	public List<Room> getAllRoom();
	public List<Room> getAllAvailableRoom();
}
