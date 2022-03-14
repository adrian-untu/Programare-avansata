package com.companyHomework;

import java.util.*;

/**
 * this class implements the Floyd-Warshall algorithm by adding the minimum cost of any "road" between two declared nodes
 */
public class Graph extends Network {
    private final List<Node> nodeLists;
    private final int[][] distances;
    private final int v;
    public Graph(List<Node> nodes) {
        this.nodeLists = nodes;
        v = nodes.size() + 1;
        distances = new int[v][v];
        for (int i = 1; i < v; i++) {
            for (int j = 1; j < v; j++) {
                if (i != j) {
                    distances[i][j] = 999999;
                } else distances[i][j] = 0;
            }
        }
        for (Node node : nodes) {
            Map<Node, Integer> costList = node.getCost();

            for (Map.Entry<Node, Integer> entry : costList.entrySet()) {
                int i = node.getLocation().charAt(1) - 48;
                int j = entry.getKey().getLocation().charAt(1) - 48;

                distances[i][j] = entry.getValue();
                distances[j][i] = entry.getValue();
            }
        }
        for (int k = 1; k < v; k++) {
            for (int i = 1; i < v; i++) {
                for (int j = 1; j < v; j++) {
                    if (distances[i][j] > distances[i][k] + distances[k][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }
    }
    public void printDist() {
        for (int i = 1; i < v; i++) {
            for (int j = 1; j < v; j++) {
                System.out.printf("%d ", distances[i][j]);
            }

            System.out.println();
        }
    }

    public int shortestTime(Node node1, Node node2) {
        int v1 = node1.getLocation().charAt(1) - 48;
        int v2 = node2.getLocation().charAt(1) - 48;
        return distances[v1][v2];
    }

}
