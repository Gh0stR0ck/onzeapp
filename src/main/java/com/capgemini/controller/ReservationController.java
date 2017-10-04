package com.capgemini.controller;

import com.capgemini.model.Reservation;
import com.capgemini.repositories.ReservationRepository;
import com.capgemini.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Iterable<Reservation> Post(@RequestBody Reservation reservation){
        repository.save(reservation);
        return repository.findAll();
    }

    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.PUT)
    public Iterable<Reservation> Put(@RequestBody Reservation reservation, @PathVariable long reservationNumber){
        repository.save(reservation);
        return repository.findAll();
    }


    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.GET)
    public Reservation Get(@PathVariable long reservationNumber){
        return repository.findOne(reservationNumber);
    }

    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.DELETE)
    public Boolean Delete(@PathVariable long reservationNumber){
        repository.delete(reservationNumber);
        return true;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Reservation> GetAll(){
        return repository.findAll();
    }
}

