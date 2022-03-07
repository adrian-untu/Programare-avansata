package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is abstract so the inheritance can be properly implemented
 * Here I implemented mostly getters and setters with the basic specifications of all the objects, having
 * in mind that I wanted to give certain objects certain extra attributes
 */
public abstract class Node {
    private static List<String> nameList;
    private String name;
    private String address;
    private String location;

    static {
        nameList = new ArrayList<>();
    }

    public List<String> getnameList() {
        return nameList;
    }

    public void setnameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) throws NameException {
        if(!nameList.isEmpty() && nameList.contains(name))
            throw new NameException("The node already exists!");
        else {
            this.name = name;
            nameList.add(name);
        }
    }

    public String getAddress(){
        return address;
    }

    public String setAddress(String address){
        this.address = address;
        return address;
    }

    public String getLocation(){
        return location;
    }

    public String setLocation(String location){
        this.location = location;
        return location;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
