package com.company;

public class Main {

    public static void main(String[] args) {
        Event C1=new Event("C1",100,8,10);
        Event C2=new Event("C2", 100, 10, 12);
        Event L1=new Event("L1", 30, 8, 10);
        Event L2=new Event("L2", 30, 8, 10);
        Event L3=new Event("L3", 30, 10, 12);
        Computer_Labs R401=new Computer_Labs("401", 30);
        Computer_Labs R403=new Computer_Labs("403", 30);
        Computer_Labs R405=new Computer_Labs("405", 30);
        Lecture_Halls R309=new Lecture_Halls("309", 100);//am definit exemplele dupa formatul definit in constructori
        //System.out.println("Events: " + C1 + C2 + L1 + L2 + L3);//am afisat evenimentele
        //System.out.println("Rooms: " + R401 + R403 + R405 + R309);//am afisat camerele
        Solution solution = new Solution();
        solution.setRooms(R401, R403, R405, R309);
        solution.setEvents(C1, C2, L1, L2, L3);
        System.out.println(solution);
    }
}
