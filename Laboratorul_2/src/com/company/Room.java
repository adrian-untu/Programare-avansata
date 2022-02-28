package com.company;

public class Room{
    private String name;
    private int capacity;
    RoomTypes rooms;
    public Room(String name, int capacity, RoomTypes rooms){
        this.name = name;
        this.capacity = capacity;
        this.rooms = rooms;
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
    public String Tipuri(){
        return switch (this.rooms) {
            case LABORATOR -> "LABORATOR";
            case LECTURE_HALL -> "LECTURE_HALL";
        };
    }//am facut o functie de tip String care converteste elementele din enum-ul din RoomTypes in String-uri pentru a putea fi afisate de functia toString
    public String toString() {
        return this.name + "(cap=" + this.capacity + ", " + Tipuri() + "), ";
    }//am suprascris toString() pentru a afisa dupa formatul cerut
}
