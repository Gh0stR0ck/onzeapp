package com.capgemini.controller;

import com.capgemini.model.Room;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/room")
public class RoomController {
    private List<Room> Roomlist = new ArrayList<Room>();

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public List<Room> Post(@RequestBody Room room){
        this.Roomlist.add(room);
        return this.Roomlist;
    }

    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.PUT)
    public List<Room> Put(@RequestBody Room room, @PathVariable int roomNumber){

        for(Room tmproom : this.Roomlist){
            if(tmproom.getNumber() == roomNumber){
                tmproom.setName(room.getName());
                tmproom.setCapacity(room.getCapacity());
                break;
            };
        }

        return this.Roomlist;
    }


    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.GET)
    public Room Get(@PathVariable int roomNumber){ ;
        for(Room tmproom : this.Roomlist){
            if(tmproom.getNumber() == roomNumber) return tmproom;
        }
        return new Room();
    }

    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.DELETE)
    public List<Room> Delete(@PathVariable int roomNumber){ ;
        for(Room tmproom : this.Roomlist){
            if(tmproom.getNumber() == roomNumber) {
                this.Roomlist.remove(tmproom);
                break;
            }
        }
        return this.Roomlist;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Room> GetAll(){
        return this.Roomlist;
    }
}
