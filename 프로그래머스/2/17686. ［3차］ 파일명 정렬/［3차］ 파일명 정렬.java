import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<File> li = new ArrayList<>();
        String[] answer = {};
        int idx = 0;
        for(String file: files){
            String[] s = file.split("");
            int numstart=0;
            for(int i = 0; i < file.length(); i++){
                if(s[i].matches("[0-9]")){
                    numstart = i;
                    break;
                }
            }
            int numends=0;
            for(int i = numstart; i < file.length(); i++){
                if(s[i].matches("[^0-9]")){
                    numends = i;
                    break;
                }
            }
            if(numends==0) numends = file.length();
            //System.out.println("s:"+numstart+" e:"+ numends);
            String head = file.substring(0, numstart).toUpperCase();
            String number = file.substring(numstart, numends);
            String tail = file.substring(numends);
            
            File f = new File(file, head, Integer.parseInt(number), idx);
            li.add(f);
            idx++;
        }
        
        Collections.sort(li);
        //System.out.println(li);
        
        answer = li.stream().map(File::toString).toArray(String[]::new);
        return answer;
    }
}

class File implements Comparable<File>{
    String s;
    String head;
    int number;
    int order;
    
    public File(String s, String head, int number, int order){
        this.s = s;
        this.head = head;
        this.number = number;
        this.order = order;
    }
    
    @Override
    public int compareTo(File file) {
        if(head.equals(file.head)){
            return Integer.compare(number, file.number);
        }
        else{
            return head.compareTo(file.head);
        }
      
    }
    
    @Override
    public String toString(){
        return s;
    }
}