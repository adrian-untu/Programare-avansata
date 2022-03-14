package com.companyHomework;

import java.util.*;

/**
 * This class is abstract so the inheritance can be properly implemented
 * Here I implemented mostly getters and setters with the basic specifications of all the objects, having
 * in mind that I wanted to give certain objects certain extra attributes
 */
public abstract class Node implements Comparable<Node> {
    private final Map<Node, Integer> costs = new HashMap<>();
    private String name;
    private String location;

    public Node(String name, String location){
        this.name = name;
        this.location = location;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation(){
        return location;
    }

    public String setLocation(String location){
        this.location = location;
        return location;
    }
    @Override
    public int compareTo(Node n) {
        return this.name.compareTo(n.name);
    }

    public void setCost(Node node, int value) {
        costs.put(node, value);
    }

    public Map<Node, Integer> getCost() {
        return costs;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
