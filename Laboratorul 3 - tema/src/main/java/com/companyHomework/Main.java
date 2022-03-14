package com.companyHomework;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args)  {

        Node v1 = new Computer("A", "v1", "A3:V3", 100);
        Node v2 = new Router("A", "v2", "B2:C3");
        Node v3 = new Switch("A", "v3");
        Node v4 = new Switch("B", "v4");
        Node v5 = new Router("B", "v5", "A1:B3");
        Node v6 = new Computer("B", "v6", "C2:D6", 200);

        Network network = new Network();

        network.addNode(v1);
        network.addNode(v2);
        network.addNode(v3);
        network.addNode(v4);
        network.addNode(v5);
        network.addNode(v6);

        System.out.println(network);//print the nodes of our network, no matter what type they are

        v1.setCost(v2, 10);
        v1.setCost(v3, 50);
        v2.setCost(v3, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 20);
        v3.setCost(v4, 10);
        v4.setCost(v5, 30);
        v4.setCost(v6, 10);
        v5.setCost(v6, 20);

        System.out.println("\nThe shortest times required for data packets to travel from an identifiable node to another is:");

        System.out.println("From  To      Cost");
        for (Node node : network.getNodeList()) {
            Map<Node, Integer> cost = node.getCost();

            for (Map.Entry<Node, Integer> entry : cost.entrySet()) {
                System.out.println(node.getLocation() + " -- " + entry.getKey().getLocation() + "        " + entry.getValue());
            }
        }

        Graph sol = new Graph(network.getNodeList());
        List<Node> verifiedList = network.getIdentifiable();
        System.out.println("\nIdentifiable nodes are: " + verifiedList);
        System.out.println("\nAll the shortest time required for data packets to travel from one identifiable node to another is:");
        System.out.println("From  To      Cost");
        for (Node n1 : verifiedList) {
            for (Node n2 : verifiedList) {
                if (!n1.getName().equals(n2.getName())) {
                    System.out.println(n1.getLocation() + " -- " + n2.getLocation() + "        " + sol.shortestTime(n1, n2));
                }
            }
        }
    }
}
