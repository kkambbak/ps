import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.Arrays.binarySearch;

public class Main {
    static int n;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        br.close();

        long[] sortedArr = Arrays.stream(arr).distinct().sorted().toArray();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int i1 = binarySearch(sortedArr, arr[i]);
            sb.append(i1);
            sb.append(' ');
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(sb.toString());
        bw.flush();
        bw.close();
    }
}