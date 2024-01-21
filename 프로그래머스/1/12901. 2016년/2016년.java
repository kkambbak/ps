class Solution {
    public String solution(int a, int b) {
        int[] days = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int daySum = 0;
        for(int i = 0; i < a-1; i++){
            daySum += days[i];
        }        
        daySum += b;
        return day[daySum % 7];
    }
}