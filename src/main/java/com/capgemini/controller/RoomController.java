package com.capgemini.controller;

import com.capgemini.model.Room;
import com.capgemini.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/room")
public class RoomController {
    private List<Room> Roomlist = new ArrayList<>();

    @Autowired
    private RoomRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Iterable<Room> Post(@RequestBody Room room){
        repository.save(room);
        return repository.findAll();
    }

    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.PUT)
    public Iterable<Room> Put(@RequestBody Room room, @PathVariable long roomNumber){
        repository.save(room);
        return repository.findAll();
    }


    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.GET)
    public Room Get(@PathVariable long roomNumber){
        return repository.findOne(roomNumber);
    }

    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.DELETE)
    public Iterable<Room> Delete(@PathVariable long roomNumber){
        repository.delete(roomNumber);
        return repository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Room> GetAll(){
        return repository.findAll();
    }
}
