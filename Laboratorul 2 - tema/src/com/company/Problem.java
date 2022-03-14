package com.company;
import java.util.ArrayList;
import java.util.List;

public class Problem {
    private List<Event> events;
    private List<Room> rooms;
    public Problem(){
        events = new ArrayList<Event>();
        rooms = new ArrayList<Room>();
    }
    public void setEvents(Event e1, Event e2, Event e3, Event e4, Event e5){
        events.add(e1);
        events.add(e2);
        events.add(e3);
        events.add(e4);
        events.add(e5);
    }
    public void setRooms(Computer_Labs r1, Computer_Labs r2, Computer_Labs r3, Lecture_Halls r4){
        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        rooms.add(r4);
    }
    public List<Room> getRooms(){
        List<Room> rooms1 = new ArrayList<Room>();
        System.out.println("Camerele sunt: ");
        for(Room r: rooms)
            rooms1.add(r);
        return rooms1;
    }
    public List<Event> getEvents(){
        List<Event> events1 = new ArrayList<Event>();
        System.out.println("Evenimentele sunt: ");
        for(Event e: events)
            events1.add(e);
        return events1;
    }
    public String toString(){
        String s = new String();
        s += "Aceasta problema are urmatoarele camere: ";
        for(Room r: rooms)
            if(rooms.indexOf(r) == rooms.size() - 1)
                s += r.getName() + ".";
            else
                s += r.getName() + ",";
        s += " Aceasta problema are urmatoarele evenimente: ";
        for(Event e: events)
            if(events.indexOf(e) == events.size() - 1)
                s += e.getName() + ".";
            else
                s += e.getName() + ",";
        return s;
    }
}
