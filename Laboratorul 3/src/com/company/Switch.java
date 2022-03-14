package com.company;

/**
 * This class is with inherited functions from Node class
 */
public class Switch extends Node{

    Switch(String name, String address, String location) throws NameException{
        setName(name);
        setAddress(address);
        setLocation(location);
    }
    public String toString(){
        return getName() + "(Switch " + getLocation() + ")";
    }
}
