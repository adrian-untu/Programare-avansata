package Lab7.homework;

import java.io.*;
import java.util.Scanner;

public class MockDictionary extends Dictionary {
    @Override
    public boolean isWord(String str) {
        try {
            File myObj = new File("E:\\Semestrul 2, anul 2\\Programare avansata\\GitHub\\Laboratorul 7\\MockDictionary");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(str.equals(data.toUpperCase()))
                    return true;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        return false;
    }
}
