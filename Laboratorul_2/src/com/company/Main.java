package com.company;

import static com.company.RoomTypes.LABORATOR;
import static com.company.RoomTypes.LECTURE_HALL;

public class Main {

    public static void main(String[] args) {
        Event C1=new Event("C1",100,8,10);
        Event C2=new Event("C2", 100, 10, 2);
        Event L1=new Event("L1", 30, 8, 10);
        Event L2=new Event("L2", 30, 8, 10);
        Event L3=new Event("L3", 30, 10, 12);
        Room R1=new Room("401", 30, LABORATOR);
        Room R2=new Room("403", 30, LABORATOR);
        Room R3=new Room("405", 30, LABORATOR);
        Room R4=new Room("309", 100, LECTURE_HALL);//am definit exemplele dupa formatul definit in constructor
        System.out.println("Events: " + C1+C2+L1+L2+L3);//am afisat evenimentele
        System.out.println("Rooms: " + R1+R2+R3+R4);//am afisat camerele


    }
}
