package Lab4.homework;
import java.util.*;
import java.util.stream.Collectors;

public class City {
    private final List<Intersection> intersections;
    private final List<Streets> streets;
    private final Map<Intersection, List<Streets>> cityMap = new HashMap<>();

    public City(Set<Intersection> intersections, List<Streets> streets) {
        this.intersections = new ArrayList<>(intersections);
        this.streets = streets;
    }

    public List<Intersection> getIntersections() {
        return intersections;
    }

    public List<Streets> getStreets() {
        return streets;
    }
//getters and setters, plus the map of the city via a list
    public void printOnScreen(int value) {
        for (Intersection intersection : intersections) {
            List<Streets> streetList = new ArrayList<>();
            for (Streets street : streets) {
                if (street.getI1() == intersection || street.getI2() == intersection) {
                    streetList.add(street);
                }
            }
            cityMap.put(intersection, streetList);
            System.out.println(intersection.getName() + " is adjacent to " + streetList);
        }//here I printed all the streets that are adjacent to a certain intersection by using the getters from the Intersection class and seeing if it has all the required values
        List<List<Streets>> target = new ArrayList<>();
        for (var street1 : streets) {
            for (var street2 : streets) {
                for (var street3 : streets) {
                    if (street1 != street2 && street1 != street3 && street2 != street3) {
                        List<Streets> streetList = Arrays.asList(street1, street2, street3);
                        target.add(streetList);
                    }
                }
            }
        }
        Set<Intersection> intersectionList = new HashSet<>();
        int index = 0;
        for (var variabila : target) {
            List<Intersection> result = intersections.stream()
                    .filter(v -> cityMap.get(v).containsAll(variabila))
                    .collect(Collectors.toList());

            intersectionList.addAll(result);
        }
        System.out.print("\nResult:");
        List<Streets> streetList = streets.stream()
                .filter(street -> (intersectionList.contains(street.getI1()) || intersectionList.contains(street.getI2())))
                .filter(street -> street.getLength() >= value)
                .distinct()
                .collect(Collectors.toList());

        for (Streets street : streetList) {
            System.out.print(street);
        }
    }//this function utilises streams to print all the streets in the city
    @Override
    public String toString() {
        return "City{" +
                "intersections = " + intersections +
                ",\nstreets = " + streets +
                '}';
    }
}
