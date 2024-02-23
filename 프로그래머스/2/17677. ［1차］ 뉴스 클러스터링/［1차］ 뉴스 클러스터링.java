import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        ArrayList<String> set1 = new ArrayList<>();
        for(int i = 0; i < str1.length()-1; i++){
            String s = str1.substring(i,i+2);
            if(s.matches("^[a-zA-Z]*$"))
                set1.add(s);
        }
        
        ArrayList<String> set2 = new ArrayList<>();
        int cnt=0;
        for(int i = 0; i < str2.length()-1; i++){
            String s = str2.substring(i,i+2);
            if(s.matches("^[a-zA-Z]*$"))
                set2.add(s);
            
        }
        ArrayList<String> hap = new ArrayList<>();
        ArrayList<String> gyo = new ArrayList<>();
        
        for(String s: set1){
            if(set2.remove(s)){
                gyo.add(s);
            }
            hap.add(s);
        }
        hap.addAll(set2);
        
        int g = gyo.size();
        int h = hap.size();
        
        if(h==0) return 65536;
        return (int)(((double) g / h) * 65536);
    }
}