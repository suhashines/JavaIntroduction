package FileIO;

import java.io.File;

public class DeleteFileDemo {
    public static void main(String[] args) {
        File file = new File("check-demo.txt");

        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Unable to delete file.");
        }
    }
}
