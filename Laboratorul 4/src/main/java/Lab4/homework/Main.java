package Lab4.homework;

import java.util.*;
import java.util.stream.IntStream;
import com.github.javafaker.Faker;
import org.jgrapht.Graph;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class Main {

    public static void main(String[] args){
        Faker faker = new Faker();
        var nodes = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection(faker.address().streetName()))
                .toArray(Intersection[]::new);

        System.out.println("The basic print of the list of intersection: " + Arrays.toString(nodes));


        //create and print set of intersections with HashSet implementation:
        Set<Intersection> intersectionList = new HashSet<>();
        Collections.addAll(intersectionList, nodes);

        if (nodes.length == intersectionList.size())
            System.out.println("The print of intersections list with hashset: " + intersectionList);
        else
            System.out.println("Hashset contains duplicates.");

        Streets[] streets = new Streets[16];

        streets[0] = new Streets(faker.address().streetAddress(), 2, nodes[0], nodes[1]);
        streets[1] = new Streets(faker.address().streetAddress(), 3, nodes[1], nodes[2]);
        streets[2] = new Streets(faker.address().streetAddress(), 1, nodes[2], nodes[3]);
        streets[3] = new Streets(faker.address().streetAddress(), 1, nodes[3], nodes[4]);
        streets[4] = new Streets(faker.address().streetAddress(), 2, nodes[0], nodes[6]);
        streets[5] = new Streets(faker.address().streetAddress(), 3, nodes[6], nodes[5]);
        streets[6] = new Streets(faker.address().streetAddress(), 3, nodes[5], nodes[4]);
        streets[7] = new Streets(faker.address().streetAddress(), 2, nodes[0], nodes[7]);
        streets[8] = new Streets(faker.address().streetAddress(), 2, nodes[7], nodes[8]);
        streets[9] = new Streets(faker.address().streetAddress(), 1, nodes[8], nodes[4]);
        streets[10] = new Streets(faker.address().streetAddress(), 1, nodes[6], nodes[7]);
        streets[11] = new Streets(faker.address().streetAddress(), 2, nodes[7], nodes[1]);
        streets[12] = new Streets(faker.address().streetAddress(), 1, nodes[2], nodes[5]);
        streets[13] = new Streets(faker.address().streetAddress(), 2, nodes[5], nodes[7]);
        streets[14] = new Streets(faker.address().streetAddress(), 1, nodes[8], nodes[3]);
        streets[15] = new Streets(faker.address().streetAddress(), 2, nodes[2], nodes[4]);//adding all the streets via the node
        List<Streets> streetList = new LinkedList<>();
        Collections.addAll(streetList, streets);
        Collections.sort(streetList, (street1, street2) -> Streets.sortCustom(street1, street2));
        Collections.sort(streetList);
        System.out.println("The print of streets list: " + streetList);
        City city = new City(intersectionList, streetList);
        System.out.println(city);
        city.printOnScreen(3);
        Graph<Intersection, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);//here I used a library that generates automatically our graph
        for (Intersection intersection : city.getIntersections()) {
            graph.addVertex(intersection);  // add vertex to graph
        }
        for (Streets street : streets) {
            graph.addEdge(street.getI1(), street.getI2());    // add edges to graph
            graph.setEdgeWeight(street.getI1(), street.getI2(), (double) street.getLength()); // setting the cost of all the edges by the length I mentioned in the definition of the street
        }
        KruskalMinimumSpanningTree<Intersection, DefaultWeightedEdge> tree = new KruskalMinimumSpanningTree<>(graph);//here I used a library that executes the Kruskal algorithm
//all of these functions are from certain allowed libraries that handle the problem of creating a graph and generating the minimum spanning tree
        System.out.println("\nMinimum Spanning tree is:");

        for (var variabile : tree.getSpanningTree().getEdges()) {
            Intersection intersection1 = graph.getEdgeSource(variabile);
            Intersection intersection2 = graph.getEdgeTarget(variabile);

            for (Streets street : streetList) {
                if((intersection1 == street.getI1() && intersection2 == street.getI2()) || (intersection1 == street.getI2() && intersection2 == street.getI1())) {
                    System.out.println("Intersection " + intersection1.getName() + " to " + intersection2.getName() + ", we have the street: " + street.getName());
                }
            }
        }
    }
}
