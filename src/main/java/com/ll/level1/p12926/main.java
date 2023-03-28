
public class main {
    public static void main(String[] args) {
        String s = new Solution().solution(" ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz ", 25);
        System.out.println(s);
    }
}
class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        char[] sArr = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if(sArr[i]==' '){
                sb.append(" ");
                continue;
            }
            char c = (char)(sArr[i] + n);

            if( c > 'z'){
                sb.append((char)(c-26));
            } else if (c >= 'a'+n) {
                sb.append(c);
            } else if (c > 'Z') {
                sb.append((char)(c-26));
            } else{
                sb.append(c);
            }

        }
        return sb.toString();
    }
}