package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserJson {
    public void createUserJson(){
        List<User> userArrayList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/example/fileUser.txt"))) {
            String line;
            String header = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String [] splitArrayUser = line.split("\\s+");
                String name = splitArrayUser[0];
                int age = Integer.parseInt(splitArrayUser[1]);
                userArrayList.add(new User(name, age));
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        } catch(IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(userArrayList);
        System.out.println(json);
    }
}