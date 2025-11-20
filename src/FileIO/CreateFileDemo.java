package FileIO;

import java.io.File;
import java.io.IOException;

public class CreateFileDemo {
    public static void main(String[] args) {
        try {
            File file = new File("demo.txt");

            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists!");
            }

        } catch (IOException e) {
            System.out.println("Error occurred.");
            e.printStackTrace();
        }
    }
}

