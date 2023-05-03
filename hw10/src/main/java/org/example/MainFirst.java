package org.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class MainFirst {
        public static void main(String[] args) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
                String line = reader.readLine();
                while (line != null) {
                    Pattern pattern = Pattern.compile("(\\(\\d{3}\\)\\s\\d{3}-\\d{4})|(\\d{3}-\\d{3}-\\d{4})");
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.matches()) {
                        System.out.println(matcher.group());
                    }
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

