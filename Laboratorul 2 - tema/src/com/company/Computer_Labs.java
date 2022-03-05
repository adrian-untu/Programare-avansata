package com.company;

public class Computer_Labs extends Room{
    public Computer_Labs(String name, int capacity){
        super(name,capacity);
    }
    public String toString() {
        return getName() + "(cap=" + getCapacity() + ", " + "lab), ";
    }//am suprascris toString() pentru a afisa dupa formatul cerut
    public boolean equals(Object obj) {
        if( obj == this )
            return true;
        if( !(obj instanceof Computer_Labs))
            return false;
        Computer_Labs lab = (Computer_Labs) obj;
        return (this.hashCode() == lab.hashCode());
    }

    public int hashCode() {
        int hash = 1;
        hash = hash + getName().hashCode();
        return hash;
    }
}
