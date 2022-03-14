package com.companyHomework;


import java.util.*;

/**
 * In the network I added the objects no matter their kind, with getters, setters and a custom function called "add"
 * As it is mentioned in the description of the problem, I sorted the nodes added by their name so the printing process can be executed as requested
 */
public class Network {
    private final List<Node> nodeList = new ArrayList<>();

    Network(){
    }

    public void addNode(Node node) {
        nodeList.add(node);
    }

    public List<Node> getNodeList(){
        return nodeList;
    }

    public int compareByIp(Node node1, Node node2) {
        return ((Identifiable) node1).getIp().compareTo(((Identifiable) node2).getIp());
    }

    public List<Node> getIdentifiable(){
        List<Node> verifiedList = new ArrayList<>();

        for (Node node : nodeList) {
            if (node instanceof Identifiable)
                verifiedList.add(node);
        }
        Collections.sort(verifiedList, this::compareByIp);
        return verifiedList;
    }

    public void sortList() {
        Collections.sort(nodeList, Comparator.comparing(Node::getName));
    }

    @Override
    public String toString() {
        return String.valueOf(nodeList);
    }

}

