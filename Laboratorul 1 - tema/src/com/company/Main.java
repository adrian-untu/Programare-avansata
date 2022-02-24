package com.company;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void getTime() throws InterruptedException {
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
    }
    public static String[] generateRandomWords(int numberOfWords, int lengthOfWords, String alphabet)
    {
        String[] randomStrings = new String[numberOfWords];
        Random r = new Random();
        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[lengthOfWords];
            for(int j = 0; j < lengthOfWords; j++)
            {
                word[j] = alphabet.charAt(r.nextInt(alphabet.length()));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }
   public static boolean[][] getMatriceAdiacenta(int n, int p, String[] cuvinte){
       var adiacenta = new boolean[n][n];
       for(int i = 0; i < n; i++){
           for(int k = 0; k < n; k++) {
               int ok = 0;
               for(int j = 0; j < p; j++) {
                   for (int l = 0; l < p; l++) {
                       if (cuvinte[k].charAt(j) == cuvinte[i].charAt(l)) {
                           adiacenta[k][i] = true;
                           ok = 1;
                           break;
                       }
                       if (ok == 0) {
                           adiacenta[k][i] = false;
                       }
                   }
               }
           }
       }
       System.out.println("Matricea de adiacenta este ");
       for (boolean[] ints : adiacenta) {
           for (boolean anInt : ints) {
               System.out.print(anInt + " ");
           }
           System.out.println("\n");
       }
       return adiacenta;
   }
   public static void printNeighbours (int n, int p, String[] cuvinte){
       var adiacenta = new boolean[n][n];
       String[][] vecini = new String[n][n];
       adiacenta = getMatriceAdiacenta(n, p, cuvinte);
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {

                vecini[i][j] = cuvinte[j];
            }
        }
        for(int i = 0; i < n; i++){
            System.out.println("Vecinii lui " + cuvinte[i] + " sunt: ");
            for(int j = 0; j < n; j++){
                if(adiacenta[i][j] && i != j)
                    System.out.println(cuvinte[j] + " ");
            }
            System.out.println("\n");
        }
   }
   public static boolean validareInteger(int k, String[] args){
       try {
           Integer.parseInt(args[k]);
           return true;
       } catch(NumberFormatException e){
           return false;
       }
   }
    public static boolean validareAlfabet(String args, int n)
    {
        int[] frecv = new int[27];
        if (args == null) {
            return false;
        }
        int nrcif = 0;
        while(n != 0){
            n/=10;
            nrcif++;
        }
            int i = 6 + nrcif;
            while (i < args.length()) {

                char c = args.charAt(i);
                if (!(c >= 'A' && c <= 'Z')) {
                    return false;
                }
                frecv[c - '0' - 17]++;
                if(frecv[c - '0' - 17] > 1)
                    return false;
                i = i + 3;
            }
            return true;
    }
    public static String toStrings(Object[] a) {
        if (a == null)
            return "null";

        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(String.valueOf(a[i]));
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String str = toStrings(args);
        System.out.println(str);
        var n = Integer.parseInt(args[0]);  // Read user input for numberOfWords
        if(n < 30000) {
            if (validareInteger(0, args) && validareInteger(1, args) && validareAlfabet(str, n)) {
                var p = Integer.parseInt(args[1]);  // Read user input for lengthOfWords
                int k = 2;
                String alphabet = "";
                while (k < args.length) {
                    alphabet = alphabet + args[k];
                    k++;
                }
                System.out.println(alphabet);
                String[] cuvinte = generateRandomWords(n, p, alphabet);
                System.out.println(Arrays.toString(cuvinte));

                    printNeighbours(n, p, cuvinte);
                    System.out.println("n < 30000 deci nu este necesar sa afisam timpul de executie.");
            } else {
                System.out.println("Argumentele din linia de comanda nu sunt valide. Reincercati executia liniei de comanda");
            }
        }
        else{
            getTime();
        }
    }
}