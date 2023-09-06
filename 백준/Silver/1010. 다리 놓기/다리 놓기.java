import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dp = new int[M+1][M+1];
	
			dp[1][1] = 1;
			for(int i = 1; i < M; i++) {
				dp[i][0] = 1;
			}
			
			for(int i = 2; i <= M; i++) {
				for(int j = 1; j <= N; j++) {
					dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
				}
			}
			System.out.println(dp[M][N]);
		}
	}
}