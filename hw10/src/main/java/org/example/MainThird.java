package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

    public class MainThird {
        public static void main(String[] args) throws FileNotFoundException {
            Map<String, Integer> wordFrequencyMap = countWordFrequency("words.txt");
            for (String word : wordFrequencyMap.keySet()) {
                System.out.println(word + " " + wordFrequencyMap.get(word));
            }
        }
        public static Map<String, Integer> countWordFrequency(String fileName) throws FileNotFoundException {
            Map<String, Integer> wordFrequencyMap = new HashMap<>();

            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                word = word.replaceAll("[^a-zA-Z0-9]", ""); // Видаляємо всі не-буквено-цифрові символи
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
            }

            scanner.close();
            return wordFrequencyMap;
        }


    }

