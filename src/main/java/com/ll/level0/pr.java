package com.ll.level0;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class pr {

    public static void main(String[] args) {
        int[][] dungeons = new int[4][4];
        int[] x = Arrays.stream(dungeons).min(Comparator.comparingInt(i -> i[0])).get();
        minNeedP = x[0];
        Arrays.copyOf(dungeons, dungeons.length);
    }

    private static int minNeedP;
}
abstract class ProcessingObject<T> {
    protected ProcessingObject<T> successor;
    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T output = handleWork(input);
        if (successor != null) return successor.handle(output);
        return output;
    }

    abstract protected T handleWork(T input);
}
class HeaderTextProcessing extends ProcessingObject<String>{
    public String handleWork(String text){
        return "From Raoul, : " + text;
    }
}

class SpellCheckerProcessing extends ProcessingObject<String>{
    public String handleWork(String text){
        return text.replaceAll("labda", "lambda");
    }
}