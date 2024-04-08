import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        Arrays.stream(numbers)
            .boxed()
            .sorted((i1,i2)-> 
                Integer.valueOf(i2+""+i1) - Integer.valueOf(i1+""+i2)
            )
            .forEach(i->sb.append(i));
        String s = sb.toString();
        if(s.replace("0","").equals("")) return "0";
        return sb.toString();
    }
}