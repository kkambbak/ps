import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.binarySearch;

public class Main {

    static int n;
    static int[] u;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        u = new int[n];
        for (int i = 0; i < n; i++) {
            u[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> li = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            int pos = binarySearch(li, u[i]);
            if(pos < 0){
                pos = Math.abs(pos) - 1;
            }
            li.add(pos, u[i]);
            int num;
            if(i%2 == 0){
                num = li.get(i/2);
            } else{
                num = Math.min(li.get(i / 2), li.get(i / 2 + 1));
            }
            bw.write(String.valueOf(num));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}