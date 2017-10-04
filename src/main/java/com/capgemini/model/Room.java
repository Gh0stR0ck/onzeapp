package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long number;
    private String name;
    private int capacity;

    public Room(){}

    public Room(long number, String name, int capacity){
        this.number = number;
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() { return capacity; }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return String.format("Room[number='%d',  name='%s', capacity='%d']", number, name, capacity);
    }
}
