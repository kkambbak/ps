class Solution {
    public String solution(String number, int k) {
        
        String[] split = number.split("");
        int[] num = new int[split.length];
        for(int i = 0; i < split.length; i++){
            num[i] = Integer.parseInt(split[i]);
        }
        
		StringBuilder sb = new StringBuilder();
        int idx = 0;
        
        for(int i = 0; i < number.length() - k; i++) {
			int max = 0;
			for(int j = idx; j <= i + k; j++) {
				if(max < num[j]) {
					max = num[j];
					idx = j+1;
				}
			}
			sb.append(max);
		}
        
        return sb.toString();
    }
}