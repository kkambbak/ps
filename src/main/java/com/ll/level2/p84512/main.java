package com.ll.level2.p84512;

import java.util.ArrayList;
import java.util.List;

//모음 사전
public class main {
    public static void main(String[] args) {
        new Solution().solution("EIO");
    }
}
class Solution {
    public int solution(String word) {
        int answer = 0;
        Vowels vowels = new Vowels();
        answer = vowels.indexOf(word);
        return answer;
    }
}
class Vowels{
    private List<String> vowels;
    private static final char[] CHARS = {'A', 'E', 'I', 'O', 'U'};
    public Vowels(){
        vowels = new ArrayList<>();
        makeWord("");
    }

    private void makeWord(String word){
        vowels.add(word);

        if (word.length() == 5) return;
        for (char c: CHARS){
            makeWord(word+c);
        }
    }

    public int indexOf(String word){
        return vowels.indexOf(word);
    }
}