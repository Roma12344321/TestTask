package com.martynov.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class TaskController {

    @GetMapping()
    public String getLetterInfo(@RequestParam("string") String string) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : string.toCharArray()) {
            if (frequencyMap.containsKey(ch)) {
                frequencyMap.put(ch, frequencyMap.get(ch) + 1);
            } else {
                frequencyMap.put(ch, 1);
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        StringBuilder result = new StringBuilder("{");
        for (Map.Entry<Character, Integer> entry : list) {
            if (result.length() > 1) result.append(", ");
            result.append("\"").append(entry.getKey()).append("\": ").append(entry.getValue());
        }
        result.append("}");
        return result.toString();
    }
}
