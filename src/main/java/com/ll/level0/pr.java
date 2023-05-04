package com.ll.level0;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class pr {
    public static void main(String[] args) {
        for (int i = 'a'; i <= 'z'; i++) {
            char ci = (char) i;
            for (int j = 'a'; j <= 'z'; j++) {
                char cj = (char) j;
                System.out.println("" + ci + cj+".kr");
            }
        }
    }
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