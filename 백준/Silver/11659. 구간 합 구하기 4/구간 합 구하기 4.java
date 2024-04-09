import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		d = new int[n+1];

		st = new StringTokenizer(br.readLine());

		d[0] = 0;

		for(int i = 1; i <= n; i++){
			d[i] = d[i-1] + Integer.parseInt(st.nextToken());
		}

		int[][] b = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			b[i][0] = Integer.parseInt(st.nextToken());
			b[i][1] = Integer.parseInt(st.nextToken());
		}

		new Main().solution(b);
	}

	private void solution(int[][] b) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int[] a: b){
			int answer = d[a[1]] - d[a[0]-1];
			bw.write(String.valueOf(answer));
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}
