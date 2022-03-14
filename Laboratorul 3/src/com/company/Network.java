package com.company;

import java.util.*;

/**
 * In the network I added the objects no matter their kind, with getters, setters and a custom function called "add"
 * As it is mentioned in the description of the problem, I sorted the nodes added by their name so the printing process can be executed as requested
 */
public class Network extends Node{
    private List<Node> nodeList;

    Network(){
        super();
        nodeList  = new ArrayList<>();
    }

    public String getNodeList(){
        return toString();
    }

    public void add(Node ... obj){
        for(Node n: obj)
            nodeList.add(n);
    }

    public List<String> getIdentifiable(){
        List<String> temp = new ArrayList<>();
        for(Node n: nodeList){

        }
        return temp;
    }

    public void sortList() {
        Collections.sort(nodeList, Comparator.comparing(Node::getName));
    }

    @Override
    public String toString() {
        return String.valueOf(nodeList);
    }

}
