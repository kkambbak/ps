package com.ll.level0.p120838;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashMap<String, Character> morseMap = new HashMap<>();
        for (int i = 0; i < morse.length; i++) {
            morseMap.put(morse[i], (char)('a'+i));
        }
        StringBuilder sb= new StringBuilder();
        System.out.println(morseMap.toString());
        String letter = ".... . .-.. .-.. ---";
        String[] letters = letter.split(" ");
        for (String s: letters
             ) {
            sb.append(morseMap.get(s));
        }
        String answer = sb.toString();
        System.out.println(answer);
    }
}
