package com.companyHomework;

import com.companyHomework.NameException;
import com.companyHomework.Node;

/**
 * This class is with inherited functions from Node class
 */
public class Switch extends Node {

    public Switch(String name, String location) {
        super(name, location);
    }
    public String toString(){
        return getName() + "(Switch " + getLocation() + ")";
    }
}
