import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] data, dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		data = new int[n+1][n+1];
		dp = new int[n+1][n+1];
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n+1; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				dp[i][j] = data[i][j] + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1];
			}
		}
		
		// 합을 구해야 하는 횟수 만큼 반복
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			System.out.println(dp[er][ec] - dp[er][sc-1] - dp[sr-1][ec] + dp[sr-1][sc-1]);
		}
	}

}