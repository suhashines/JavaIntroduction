package FileIO;

import java.io.*;
import java.util.Scanner;

public class ReadFileDemo {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        File file = new File("demo.txt");

        // -------------------------------------------------------------
        // Reading using Scanner (simple, beginner-friendly)
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

        BufferedWriter myWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("check-demo.txt"),"UTF-8"));

        // -------------------------------------------------------------
        //  Reading using BufferedReader (efficient & common in real apps)
        // -------------------------------------------------------------
        try {
            System.out.println("\n=== Reading using BufferedReader ===");

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("demo.txt"),"UTF-8"));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                myWriter.write(line+"\n");
            }

            br.close();
            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


