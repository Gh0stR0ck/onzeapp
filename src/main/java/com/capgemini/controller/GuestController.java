package com.capgemini.controller;

import com.capgemini.model.Guest;
import com.capgemini.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/guest")
public class GuestController {

    @Autowired
    private GuestRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Iterable<Guest> Post(@RequestBody Guest guest){
        repository.save(guest);
        return repository.findAll();
    }

    @RequestMapping(value = "/{guestNumber}/", method = RequestMethod.PUT)
    public Iterable<Guest> Put(@RequestBody Guest guest, @PathVariable long guestNumber){
        repository.save(guest);
        return repository.findAll();
    }

    @RequestMapping(value = "/{guestNumber}/", method = RequestMethod.GET)
    public Guest Get(@PathVariable long roomNumber){
        return repository.findOne(roomNumber);
    }

    @RequestMapping(value = "/{guestNumber}/", method = RequestMethod.DELETE)
    public Boolean Delete(@PathVariable long guestNumber){
        repository.delete(guestNumber);
        return true;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Guest> GetAll(){
        return repository.findAll();
    }
}
