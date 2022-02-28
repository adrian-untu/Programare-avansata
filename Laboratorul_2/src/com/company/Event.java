package com.company;

public class Event {
    private String name;
    private int size;
    private int start;
    private int end;

    public Event(String name, int size, int start, int end){
        this.name = name;
        this.size = size;
        this.start = start;
        this.end = end;
    }//constructorul clasei
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getSize(){
        return this.size;
    }
    public void setSize(int size){
        this.size = size;
    }
    public int getStart(){
        return this.start;
    }
    public void setStart(int start){
        this.start = start;
    }
    public int getEnd(){
        return this.end;
    }
    public void setEnd(int end){
        this.end = end;
    }//am facut gettere si settere pentru toti parametri
    public String toString() {
        return this.name + "(size=" + this.size + ", start" + this.start + ", end=" + this.end + "), ";
    }//am suprascris toString() pentru a afisa dupa formatul cerut
}
