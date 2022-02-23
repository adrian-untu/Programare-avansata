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
   public static int[][] getMatriceAdiacenta(int n, int p, String[] cuvinte){
       var adiacenta = new int[n][n];
       for(int i = 0; i < n; i++){
           for(int k = 0; k < n; k++) {
               int ok = 0;
               for(int j = 0; j < p; j++) {
                   for (int l = 0; l < p; l++) {
                       if (cuvinte[k].charAt(j) == cuvinte[i].charAt(l)) {
                           adiacenta[k][i] = 1;
                           ok = 1;
                           break;
                       }
                       if (ok == 0) {
                           adiacenta[k][i] = 0;
                       }
                   }
               }
           }
       }
       System.out.println("Matricea de adiacenta este ");
       for (int[] ints : adiacenta) {
           for (int anInt : ints) {
               System.out.print(anInt + " ");
           }
           System.out.println("\n");
       }
       return adiacenta;
   }
   public static void printNeighbours (int n, int p, String[] cuvinte){
       var adiacenta = new int[n][n];
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
                if(adiacenta[i][j] == 1 && i != j)
                    System.out.println(cuvinte[j] + " ");
            }
            System.out.println("\n");
        }
   }
    public static void main(String[] args) throws InterruptedException {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter value for n");
        var n = myObj.nextInt();  // Read user input for numberOfWords

        System.out.println("Enter value for p");
        var p = myObj.nextInt();  // Read user input for lengthOfWords

        myObj.nextLine();
        System.out.println("Enter words for alphabet");
        String alphabet = myObj.nextLine();
        String[] cuvinte = generateRandomWords(n, p, alphabet.replace(" ", ""));
        System.out.println(Arrays.toString(cuvinte));

        if(n >= 30000) {
            getTime();
        }
        else {
            printNeighbours(n,p,cuvinte);
            System.out.println("n < 30000 deci nu este necesar sa afisam timpul de executie.");
        }

    }
}