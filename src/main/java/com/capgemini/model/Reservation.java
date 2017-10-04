package com.capgemini.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long reservationNumber;
    private long guest;
    private long room;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean payment;

    public Reservation(){}

    public Reservation(long reservationNumber, long guest, long room, LocalDateTime startDate, LocalDateTime endDate, Boolean payment){
        this.reservationNumber = reservationNumber;
        this.guest = guest;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.payment = payment;
    }

    public long getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(long reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public long getGuest() {
        return guest;
    }

    public void setGuest(long guest) {
        this.guest = guest;
    }

    public long getRoom() {
        return room;
    }

    public void setRoom(long room) {
        this.room = room;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Boolean getPayment() {
        return payment;
    }

    public void setPayment(Boolean payment) {
        this.payment = payment;
    }
}
