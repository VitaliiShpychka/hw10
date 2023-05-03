package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


    public class MainThird {


    public static void main(String[] args) {
        Map<String, Integer> wordFrequencyMap = getWordFrequency("words.txt");
        printWordFrequency(wordFrequencyMap);
    }

    public static Map<String, Integer> getWordFrequency(String fileName) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                word = word.trim();
                if (word.isEmpty()) {
                    continue;
                }
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        return wordFrequencyMap;
    }

    public static void printWordFrequency(Map<String, Integer> wordFrequencyMap) {
        List<Map.Entry<String, Integer>> wordFrequencyList = new ArrayList<>(wordFrequencyMap.entrySet());
        wordFrequencyList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        for (Map.Entry<String, Integer> entry : wordFrequencyList) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
