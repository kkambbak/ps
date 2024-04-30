import java.util.*;

class Solution {
	int[] nums = new int[3333333];
    

	public int solution(int x, int y, int n) {
        
        
        if (x==y) return 0;
        
        Arrays.fill(nums, 9999999);
        nums[x] = 0;
        calc(x, y, n);
        
		return nums[y] == 9999999 ? -1 : nums[y];
    }
    
    public void calc(int x, int y, int n) {
        for(int i = x; i <= y; i++){
            
            if(nums[i] == 9999999) continue;
            
            if(i+n <= y){
                nums[i+n] = Math.min(nums[i]+1, nums[i+n]);
            } 
            
            if(i*2 <= y){
                nums[i*2] = Math.min(nums[i]+1, nums[i*2]);
            } 
            
            if(i*3 <= y){
                nums[i*3] = Math.min(nums[i]+1, nums[i*3]);
            }
        }
    }
}