package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

    public static void main(String[] args) {
        String inputFile = "fileToMaven.txt";
        String outputFile = "user.json";
        List<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            String[] headers = null;
            while ((line = br.readLine()) != null) {
                if (headers == null) {
                    headers = line.split(" ");
                } else {
                    String[] values = line.split(" ");
                    User user = new User();
                    for (int i = 0; i < headers.length; i++) {
                        switch (headers[i]) {
                            case "name":
                                user.setName(values[i]);
                                break;
                            case "age":
                                user.setAge(Integer.parseInt(values[i]));
                                break;
                            default:
                                break;
                        }
                    }
                    users.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try (FileWriter fw = new FileWriter(outputFile)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(users, fw);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Successfully converted " + inputFile + " to " + outputFile);
    }


}