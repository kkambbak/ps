import java.util.*;

class Solution {
    public String[] solution(String[] records) {
        String[] answer = new String[]{};
        
        Map<String, String> users = new HashMap<>();
        String[][] words = new String[records.length][3];
        List<String> li = new ArrayList<>();
        
        int idx = 0;
        for(String record: records){
            words[idx] = record.split(" ");
            switch(words[idx][0]){
                    case "Enter" -> {
                        users.put(words[idx][1], words[idx][2]);
                    }
                    case "Change" ->{
                        users.put(words[idx][1], words[idx][2]);
                    }
            }
            idx++;
        }
        
        for(int i = 0; i < records.length; i++){
            StringBuilder sb = new StringBuilder();
            String username = users.get(words[i][1]);
            switch(words[i][0]){
                    
                    case "Enter" -> {
                        sb.append(username);
                        sb.append("님이 들어왔습니다.");
                        li.add(sb.toString());
                    }
                    case "Leave" ->{
                        sb.append(username);
                        sb.append("님이 나갔습니다.");
                        li.add(sb.toString());
                    }
            }
        }
        answer = li.toArray(new String[0]);
        
        return answer;
    }
}