package com.companyHomework;

import com.companyHomework.Identifiable;
import com.companyHomework.NameException;
import com.companyHomework.Node;

/**
 * This class is with inherited functions from Node class plus some extra traits, which are verified or computer with the custom interfaces
 * With computeIndentifiable() I wanted to check if the id is what identifies the computers properly
 */
public class Router extends Node implements Identifiable {
    private String ip;

    public Router(String name, String location, String IP) {
        super(name, location);
        this.ip = IP;
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
