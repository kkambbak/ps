package com.ll.level3.p43164;
import java.util.*;
public class main {
    public static void main(String[] args) {
        new Solution().solution( new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"},{"ATL", "ICN"},{"ATL", "SFO"}});
    }
}
class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        Arrays.sort(tickets, Comparator.comparing((String[] s) -> s[0]).thenComparing(s->s[1]));
        Map<String, LinkedList<String>> map = new HashMap<>();
        for(String[] ticket: tickets){
            if(map.containsKey(ticket[0])){
                map.get(ticket[0]).add(ticket[1]);
            } else{
                LinkedList<String> newList = new LinkedList<>();
                newList.add(ticket[1]);
                map.put(ticket[0], newList);
            }
        }
        //풀이중...
        return answer;
    }
}
