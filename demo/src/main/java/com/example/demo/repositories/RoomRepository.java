package com.example.demo.repositories;

import com.example.demo.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface RoomRepository extends JpaRepository<Room, Long> {
    public Room findByName(String name);

    @Query(value = "select count(*) from room", nativeQuery = true)
    public long countTotalRooms();

    @Query(value = "SELECT COUNT(*) FROM room WHERE room_status = 'OCCUPIED'", nativeQuery = true)
    public long countOccupiedRooms();
}
