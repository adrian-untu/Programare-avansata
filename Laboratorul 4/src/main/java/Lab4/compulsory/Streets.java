package Lab4.compulsory;

import java.util.LinkedList;

public class Streets extends Intersection implements Comparable<Streets>{
    private String name;
    private final double length;
    private final Intersection i1;
    private final Intersection i2;

    Streets(String name, double length, Intersection i1, Intersection i2){
        super(name);
        this.name = name;
        this.length = length;
        this.i1 = i1;
        this.i2 = i2;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getLength(){
        return this.length;
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + (int)length +
                ", i1=" + i1.getName() +
                ", i2=" + i2.getName() +
                '}';
    }

    public static boolean checkComparable(LinkedList<Streets> streetList){
        for(Streets s: streetList) {
            if(s.getLength() != (int)s.getLength())//the function compareTo returns int to sort the lengths
                return false;
        }
        return true;
    }//this is a function that can check if the objects are comparable

    @Override
    public int compareTo(Streets s) {
        return Double.compare(length, s.length);
    }//I used method reference that was overridden

}
