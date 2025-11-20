package FileIO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


public class WriteFileDemo {
    public static void main(String[] args) {

        // -------------------------------------------------------------
        // 1️⃣ Writing using FileWriter (simple method)
        // -------------------------------------------------------------
        try {
            FileWriter writer = new FileWriter("demo.txt", true); // append mode
            writer.write("Hello Students!\n");
            writer.write("Java File I/O is important.\n");
            writer.close();
            System.out.println("Written using FileWriter.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // -------------------------------------------------------------
        // 2️⃣ Writing using BufferedWriter (more efficient)
        // -------------------------------------------------------------
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("demo.txt", true));
            bw.write("This line was written using BufferedWriter.\n");
            bw.close();
            System.out.println("Written using BufferedWriter.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // -------------------------------------------------------------
        // 3️⃣ Alternative: BufferedWriter + OutputStreamWriter
        // (good for controlling charset)
        // -------------------------------------------------------------
        try {
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream("demo.txt", true), "UTF-8")
            );
            bw.write("BufferedWriter + OutputStreamWriter example.\n");
            bw.close();
            System.out.println("Written using BufferedWriter + OutputStreamWriter.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

