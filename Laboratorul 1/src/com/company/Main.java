package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");//pentru prima parte
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};//pentru a doua parte
        int n = (int) (Math.random() * 1_000_000);
        n = n * 3;
        String binaryString="10101";
        int binar=Integer.parseInt(binaryString,2);
        n = n + binar;
        String hex="FF";
        int hexa=Integer.parseInt(hex,16);
        n = n + hexa;
        n = n * 6;
        System.out.println("n este " + n);
        int s = 0;
        while(n!=0) {
            s = s + n % 10;
            n = n / 10;
        }
        int k = 0;
        if ( s > 9)
            do {
                k = s;
                s = 0;
                while(k!=0) {
                    s = s + k % 10;
                    k /= 10;
                }
            } while ( s > 9 );
        //pentru a treia parte
        System.out.println("Willy-nilly, this semester I will learn " + languages[s]);//pentru a patra parte
    }
}
