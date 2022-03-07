package com.company;

/**
 * This class is with inherited functions from Node class plus some extra traits, which are verified or computer with the custom interfaces
 * With computeIndentifiable() I wanted to check if the id is what identifies the computers properly
 * With computeStorage() I wanted to tell the class that the storage is in GB and to assess it properly
 */
public class Computer extends Node implements Identifiable, Storage{
    private String ip;
    private int data;

    Computer(String name, String address, String location, String ip, int data) throws NameException{
        setName(name);
        setAddress(address);
        setLocation(location);
        this.ip = ip;
        this.data = data;
    }

    public boolean computeIdentifiable(){
        if(ip.isEmpty()){
            return false;
        }
        return true;
    }

    public String computeStorage(){
        return data + "GB";
    }

    public String getIp(){
        return ip;
    }

    public int getData(){
        return data;
    }

    public String toString(){
        return getName() + "(Computer " + getLocation() + ")";
    }

}
