import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        int[] book = new int[3611];
        
        for(String[] time : book_time){
            String[] t1 = time[0].split(":");
            String[] t2 = time[1].split(":");
            
            int i1 = Integer.valueOf(t1[0]) * 60 + Integer.valueOf(t1[1]);
            int i2 = Integer.valueOf(t2[0]) * 60 + Integer.valueOf(t2[1]);
            for(int i = i1; i < i2 + 10; i++){
                book[i]++;
            }
        }
        
        int a = Arrays.stream(book).max().getAsInt();
        
        return a;
    }
}