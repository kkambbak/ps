import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (i,j)-> (i[col-1] == j[col-1]) ? j[0]-i[0] : i[col-1]-j[col-1]);
        
        int[] s = new int[data.length];
        for(int i = row_begin-1; i < row_end; i++){
            for(int j = 0; j < data[0].length; j++){
                s[i] += data[i][j] % (i+1);
            }
        }
        
        for(int i = 0; i < data.length-1; i++){
            s[i+1] = s[i] ^ s[i+1];
        }
        
        return s[data.length-1];
    }
    
}