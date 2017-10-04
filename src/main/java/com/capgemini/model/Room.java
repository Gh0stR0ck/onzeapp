package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Room {

    public enum RoomType {
        BUDGET,
        EXCLUSIVE
    }

    public enum RoomSize {
        TWOPERSONS,
        FOURPERSONS
    }

    public enum RoomStatus {
        AVAILABLE,
        BLOCKED
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long roomNumber;
    private RoomType roomType;
    private RoomSize roomSize;
    private LocalDateTime dateAvailable;
    private RoomStatus roomStatus;

    public Room(){}

    public Room(long roomNumber, RoomType roomType, RoomSize roomSize, LocalDateTime dateAvailable, RoomStatus roomStatus){
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomSize = roomSize;
        this.dateAvailable = dateAvailable;
        this.roomStatus = roomStatus;
    }

    public long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public RoomSize getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(RoomSize roomSize) {
        this.roomSize = roomSize;
    }

    public LocalDateTime getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(LocalDateTime dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }
}
