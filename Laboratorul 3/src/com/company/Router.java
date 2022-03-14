package com.company;

/**
 * This class is with inherited functions from Node class plus some extra traits, which are verified or computer with the custom interfaces
 * With computeIndentifiable() I wanted to check if the id is what identifies the computers properly
 */
public class Router extends Node implements Identifiable{
    private String ip;

    Router(String name, String address, String location, String ip) throws NameException{
        setName(name);
        setAddress(address);
        setLocation(location);
        this.ip = ip;
    }

    public boolean computeIdentifiable(){
        if(ip.isEmpty()){
            return false;
        }
        return true;
    }

    public String getIp(){
        return ip;
    }
    public String toString(){
        return getName() + "(Router " + getLocation() + ")";
    }
}
