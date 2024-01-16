import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        
        if(a==b && b==c && c==d){
            answer = a*1111;
        }
        //3
        else if(a==b && b==c && a!=d){
            return (10*a+d) * (10*a+d);
        } else if(a==b && b==d && a!=c){
            return (10*a+c) * (10*a+c);
        } else if(a==c && c==d && a!=b){
            return (10*a+b) * (10*a+b);
        } else if(b==c && c==d && a!=b){
            return (10*b+a) * (10*b+a);
        }
        //각 2개씩
        else if(a==b && c==d){
            return (a+c) * Math.abs(a-c);
        } else if(a==c&& b==d){
            return (a+b) * Math.abs(a-b);
        } else if(a==d && b==c){
            return (a+b) * Math.abs(a-b);
        } 
        //2개가 같고, q,r
        else if(a==b && a!=c && c!=d){
            return c*d;
        } else if(a==c && a!=b && b!=d){
            return b*d;
        } else if(a==d && a!=b && b!=c){
            return b*c;
        } else if(b==c && b!=a && a!=d){
            return a*d;
        } else if(b==d && b!=a && a!=c){
            return a*c;
        } else if(c==d && c!=a && a!=b){
            return a*b;
        } 
        else{
            int[] arr = new int[]{a,b,c,d};
            Arrays.sort(arr);
            answer = arr[0];
        }
        return answer;
    }
}