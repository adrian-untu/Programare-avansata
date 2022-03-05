package com.company;

public class Lecture_Halls extends Room{
    public Lecture_Halls(String name, int capacity){
        super(name,capacity);
    }
    public String toString() {
        return getName() + "(cap=" + getCapacity() + ", " + "lecture hall), ";
    }//am suprascris toString() pentru a afisa dupa formatul cerut
    public boolean equals(Object obj) {
        if( obj == this )
            return true;
        if( !(obj instanceof Lecture_Halls))
            return false;
        Lecture_Halls lect = (Lecture_Halls)obj;
        return (this.hashCode() == lect.hashCode());
    }

    public int hashCode() {
        int hash = 1;
        hash = hash + getName().hashCode();
        return hash;
    }
}
