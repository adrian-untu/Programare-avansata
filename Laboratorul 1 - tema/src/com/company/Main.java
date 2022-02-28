package com.company;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
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
    public static boolean[][] getMatriceAdiacenta2(int n, int p, String[] cuvinte){
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
    public static void printNeighbours2 (int n, int p, String[] cuvinte){
        var adiacenta = new boolean[n][n];
        String[][] vecini = new String[n][n];
        adiacenta = getMatriceAdiacenta2(n, p, cuvinte);
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {

                vecini[i][j] = cuvinte[j];
            }
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
    public static boolean validareAlfabet(String args, int arg1, int arg2, String[] args2)
    {
        if(validareInteger(0, args2) && validareInteger(1, args2)) {
            var n = Integer.parseInt(args2[arg1]);  // Read user input for numberOfWords
            var p = Integer.parseInt(args2[arg2]);  // Read user input for lengthOfWords
        int[] frecv = new int[args.length()];
        if (args == null) {
            return false;
        }
        int nrcif = 0;
        while(n != 0){
            n/=10;
            nrcif++;
        }
        int nrcif1 = 0;
        while(p != 0){
            p/=10;
            nrcif1++;
        }
            int i = 5 + nrcif + nrcif1;
            while (i < args.length()) {
                char c = args.charAt(i);
                if (!(c >= 'A' && c <= 'Z')) {
                    return false;
                }
                frecv[c - '0' - 17]++;
                if(frecv[c - '0' - 17] == 2)
                    return false;
                i = i + 3;
            }
            return true;
        }
        else {
            return false;
        }
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
        long startTime = System.nanoTime();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String str = toStrings(args);
        if (validareInteger(0, args) && validareInteger(1, args) && validareAlfabet(str, 0, 1, args)) {
            var n = Integer.parseInt(args[0]);  // Read user input for numberOfWords
            var p = Integer.parseInt(args[1]);  // Read user input for lengthOfWords
            if (n < 30000) {
                    int k = 2;
                    String alphabet = "";
                    while (k < args.length) {
                        alphabet = alphabet + args[k];
                        k++;
                    }
                    String[] cuvinte = generateRandomWords(n, p, alphabet);
                    System.out.println(Arrays.toString(cuvinte));

                    printNeighbours(n, p, cuvinte);
                    System.out.println("n < 30000 deci nu este necesar sa afisam timpul de executie.");
                }
               else {
                int k = 2;
                String alphabet = "";
                while (k < args.length) {
                    alphabet = alphabet + args[k];
                    k++;
                }
                String[] cuvinte = generateRandomWords(n, p, alphabet);
                printNeighbours2(n, p, cuvinte);
                long endTime = System.nanoTime();
                long timeElapsed = endTime - startTime;
                System.out.println("Execution time in nanoseconds: " + timeElapsed);
            }
        }
        else {
                    if (!validareInteger(0, args))
                        System.out.println("Argumentul aferent lui n nu este valid.");
                    if (!validareInteger(1, args))
                        System.out.println("Argumentul aferent lui p nu este valid.");
                    if (!validareAlfabet(str, 0, 1, args))
                        System.out.println("Alfabetul nu este valid.");
                    System.out.println("Reincercati executia liniei de comanda.");
                }
            }
        }