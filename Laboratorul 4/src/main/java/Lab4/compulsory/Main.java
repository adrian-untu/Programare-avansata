package Lab4.compulsory;

import java.util.*;

import static Lab4.compulsory.Intersection.checkDuplicates;
import static Lab4.compulsory.Streets.checkComparable;

public class Main {

    public static void main(String[] args){

        Intersection v0 = new Intersection("v0");
        Intersection v1 = new Intersection("v1");
        Intersection v2 = new Intersection("v2");
        Intersection v3 = new Intersection("v3");

        List<Intersection> nodeList = new ArrayList<>();
        nodeList.add(v0);
        nodeList.add(v1);
        nodeList.add(v2);
        nodeList.add(v3);

        System.out.println("The basic print of the list: " + nodeList);

        //create the intersection list with streams:
        List<Intersection> newSortedList = nodeList.stream()
                .sorted(Comparator.comparing(Intersection::getName)).toList();
        System.out.println("The list printed with streams: " + newSortedList);

        //create and print set of intersections with HashSet implementation:
        HashSet<Intersection> hashset = new HashSet<>(newSortedList);
        if(checkDuplicates(hashset))
            System.out.println("The list printed with hashset: " + hashset);
        else
            System.out.println("The hashset contains duplicates.");

        //create and print linked list for streets:
        LinkedList<Streets> streetList= new LinkedList<>();
        Streets s1 = new Streets("s1", 20, nodeList.get(0), nodeList.get(1));
        Streets s2 = new Streets("s2", 30, nodeList.get(0), nodeList.get(2));
        Streets s3 = new Streets("s3", 20, nodeList.get(1), nodeList.get(2));
        Streets s4 = new Streets("s4", 40.00, nodeList.get(2), nodeList.get(3));
        streetList.add(s1);
        streetList.add(s2);
        streetList.add(s3);
        streetList.add(s4);
        Collections.sort(streetList);
        if(checkComparable(streetList))
            System.out.println("The list of streets with linked list: " + streetList);
        else
            System.out.println("The list of streets is not comparable.");

    }

}
