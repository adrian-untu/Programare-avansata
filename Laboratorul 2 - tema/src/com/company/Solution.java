package com.company;

import java.util.ArrayList;
import java.util.List;

public class Solution{
    private final List<Event> events;
    private final List<Room> rooms;
    public Solution(){
        events = new ArrayList<>();
        rooms = new ArrayList<>();
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
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(Event e: events) {
            for (Room r : rooms) {
                if (e.getSize() == r.getCapacity()) {
                    for (Event e1 : events) {
                        if (e1.getStart() != e.getStart() && !e1.equals(e) && e1.getSize() == e.getSize()) {
                            s.append(e.getName()).append(" -> ").append(r.getName()).append("\n");
                            break;
                        }
                    }
                    break;
                }
            }
        }
            return s.toString();
    }
}
