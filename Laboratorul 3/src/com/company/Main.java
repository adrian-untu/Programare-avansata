package com.company;

/**
 * In my main function, I wanted to prove that all the objects that I added are displayed in the order of their names, no matter the type
 * The main function throws the custom exception that I created when it spots two nodes with the same name
 */
public class Main {

    public static void main(String[] args) throws NameException {
        Computer v1 = new Computer("v1", "8234", "A", "127.0.0.1",32);
        Router v2 = new Router("v2", "8234", "A", "127.0.0.1");
        Switch v3 = new Switch("v3", "8234", "A");
        Switch v4 = new Switch("v4", "6345", "B");
        Router v5 = new Router("v5", "6345", "B", "634.34.43.3");
        Computer v6 = new Computer("v6", "6345", "B","634.34.43.3", 84);

        Network network = new Network();
        network.add(v5, v3, v2, v6, v4, v1);
        network.sortList();
        System.out.println("locations are: " + network);
    }
}
