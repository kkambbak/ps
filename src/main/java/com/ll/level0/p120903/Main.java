package com.ll.level0.p120903;

import java.util.ArrayList;
    import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution());
    }
}
class Solution{
    public int solution(){
        String[] s1 =  {"a", "b", "c"};
        String[] s2 = {"com", "b", "d", "p", "c"};


        ArrayList<String> s3 = new ArrayList<>(Arrays.asList(s1));
        s3.retainAll(Arrays.asList(s2));

        //return s3.size();

        int n = 3;
        StringBuilder sb = new StringBuilder();

        for (int i = 1 ; i <= n ; i++){
            sb.delete(0,n);
            for(int j = n-i+1 ; j <= n ; j++)
                sb.append("*");
            System.out.println("s");
        }


        int n1 = 2;

        double sqrtNum = Math.sqrt(n);
        int answer;
        answer= sqrtNum*sqrtNum == n ? 1 : 2;

        System.out.println(n);
        System.out.println(sqrtNum*sqrtNum);

        String my_string = "CCCccc";
        String ss2 =  Arrays.stream(my_string.split(""))
                .map(s -> ((int)s.charAt(0) > 96) ? Character.toString((char)((int)s.charAt(0) - 32)): Character.toString((char)((int)s.charAt(0) + 32)))
                .collect(Collectors.joining());

        System.out.println(ss2);

        StringBuilder sb1 = new StringBuilder();


        return answer;


    }

}
