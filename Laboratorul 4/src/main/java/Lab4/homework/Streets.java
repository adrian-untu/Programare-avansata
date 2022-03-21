package Lab4.homework;

import java.util.LinkedList;

public class Streets extends Intersection implements Comparable<Streets>{
    private String name;
    private int length;
    private Intersection i1;
    private Intersection i2;

    Streets(String name, int length, Intersection i1, Intersection i2){
        super(name);
        this.name = name;
        this.length = length;
        this.i1 = i1;
        this.i2 = i2;
    }

    public static int sortCustom(Streets street1, Streets street2) {
        return Integer.compare(street1.getLength(), street2.getLength());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Intersection getI1() {
        return i1;
    }

    public void setI1(Intersection i1) {
        this.i1 = i1;
    }

    public Intersection getI2() {
        return i2;
    }

    public void setI2(Intersection i2) {
        this.i2 = i2;
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + (int)length +
                ", intersection 1=" + i1.getName() +
                ", intersection 2=" + i2.getName() +
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
