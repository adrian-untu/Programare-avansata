package com.company;

abstract class Room{
    private String name;
    private int capacity;
    public Room(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }//gettere si settere

}
