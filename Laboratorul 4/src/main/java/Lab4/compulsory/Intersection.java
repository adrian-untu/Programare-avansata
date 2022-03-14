package Lab4.compulsory;

import java.util.*;

public class Intersection {
    private List<Intersection> nodeList;
    private String name;
    Intersection(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public List<Intersection> getNodeList(){
        return nodeList;
    }
    public void setNodeList(List<Intersection> nodeList) {
        this.nodeList = nodeList;
    }
    public static boolean checkDuplicates(HashSet<Intersection> hashset){
        for(Intersection i: hashset){
            for(Intersection i1: hashset){
                if(i.getName() == i1.getName() && !i1.equals(i))
                    return false;
            }
        }
        return true;
    }//this is a function that can check if there are any duplicates in our hashset

    @Override
    public String toString() {
        return "Intersection{" +
                " name='" + name + '\'' +
                '}';
    }


}
