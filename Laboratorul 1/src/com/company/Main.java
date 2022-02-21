package com.company;

public class Main {
    public static int getControlDigit (int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 9 == 0) {
            return 9;
        }
        return n % 10;
    }


    public static void main(String[] args) {
        System.out.println("Hello, World!");//pentru prima parte
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};//pentru a doua parte
        int n = (int) (Math.random() * 1_000_000);
        n = (n * 3 + 0b10101 + 0xFF) * 6;
        System.out.println("n este " + n);
       int result = getControlDigit(n);
        //pentru a treia parte
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);//pentru a patra parte
    }
}
