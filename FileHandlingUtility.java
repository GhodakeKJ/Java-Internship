import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    // Method to create a new file
    public static void createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    // Method to write data to a file
    public static void writeToFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Method to read data from a file
    public static void readFromFile(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File does not exist.");
                return;
            }

            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    // Method to modify data in a file
    public static void modifyFile(String fileName, String oldText, String newText) {
        try {
            // Reading the file into a StringBuffer
            File file = new File(fileName);
            StringBuffer content = new StringBuffer();
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                content.append(line.replaceAll(oldText, newText) + System.lineSeparator());
            }
            reader.close();

            // Writing the modified content back to the file
            FileWriter writer = new FileWriter(fileName);
            writer.write(content.toString());
            writer.close();
            System.out.println("File modified successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred while modifying the file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String fileName = "sample.txt";

        // Creating a file
        createFile(fileName);

        // Writing to the file
        writeToFile(fileName, "Hello, this is a test file.\nThis is Karan Jaywant Ghodake.\nSoftware Developer.");

        // Reading from the file
        System.out.println("Reading from file:");
        readFromFile(fileName);

        // Modifying the content in the file
        modifyFile(fileName, "second", "modified");
        
        // Reading the modified file
        System.out.println("Reading from file after modification:");
        readFromFile(fileName);
    }
}
