package com.ll.boj.hash.p1620;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        String[] dogam = new String[n+2];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            dogam[i] = s;
            map.put(s, i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            boolean matches = s.matches("^[0-9]+");
            if(matches){
                String pokemon = dogam[Integer.parseInt(s)];
                bw.write(pokemon);
            } else{
                bw.write(String.valueOf(map.get(s)));
            }
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
