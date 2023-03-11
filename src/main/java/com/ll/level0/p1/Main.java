package com.ll.level0.p1;

import java.util.ArrayList;
import java.util.Stack;

import static java.lang.Math.sqrt;
public class Main {
    public static void main(String[] args) {
        //1600851475143의 소인수 중에서 가장 큰 수를 구하세요.
        //1. sqrt(num)까지 forloop 돌려 나눠서 소수를 찾기
        //2. 소인수분해
        long num = 1600851475143L;
        long sqrtNum = (long)Math.sqrt(num);
        ArrayList<Long> primeNums = new ArrayList<>();
        for (long i = 2; i <= sqrtNum; i++) {
            if(num % i == 0) {
                primeNums.add(i);
            }
        }
        int[] arr = new int[primeNums.size()];
        System.out.println(primeNums.toString()); //[3, 9, 19, 57, 171, 557, 1671, 5013, 10583, 31749, 95247]
        int idx = 0;
        long prime = primeNums.get(idx);
        while (num!=0){
            if(num % prime == 0){
                arr[idx]++;
                num/=prime;
                System.out.println(arr[idx] +" "+ primeNums.get(idx));
                System.out.println(num);
            }
            else{
                idx++;
                prime = primeNums.get(idx);
                if(idx >= primeNums.size()) break;
            }
            System.out.println("arr[idx] = " + arr[idx] +", idx= "+ idx);
        }

        System.out.println();
    }
}

class Polynomial{
    String s;
    Polynomial(String s){
        this.s = s;
    }

    public int calc(){
        String []parseS = s.split(" ");
        ArrayList<Integer> nums ;
        Stack<String> stack;
        System.out.println(parseS[1]);
        for (String s: parseS){
            if (s == "\\*");
        }
        return 6;
    }
}
