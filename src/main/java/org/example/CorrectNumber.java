package org.example;

import java.io.*;
import java.util.Scanner;

public class CorrectNumber {
    private static final String PATTERN1 = "\\(\\d{3}\\) \\d{3}-\\d{4}";
    private static final String PATTERN2 = "\\d{3}-\\d{3}-\\d{4}";
    public void correctPhoneNumber(){

        File file = new File("src/main/java/org/example/file.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            if(file.length() == 0) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write("987-123-4567\n");
                    writer.write("123 456 7890\n");
                    writer.write("(123) 456-7890\n");
                }

            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.matches(PATTERN1) || line.matches(PATTERN2)) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
