package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFileDemo {
    public static void main(String[] args) {

        File file = new File("demo.txt");

        // -------------------------------------------------------------
        // 1️⃣ Reading using Scanner (simple, beginner-friendly)
        // -------------------------------------------------------------
        try {
            System.out.println("=== Reading using Scanner ===");

            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        // -------------------------------------------------------------
        // 2️⃣ Reading using BufferedReader (efficient & common in real apps)
        // -------------------------------------------------------------
        try {
            System.out.println("\n=== Reading using BufferedReader ===");

            BufferedReader br = new BufferedReader(new FileReader("demo.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


