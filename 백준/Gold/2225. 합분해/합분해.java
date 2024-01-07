import java.io.*;
import java.util.*;

public class Main {
	static int N, K, answer = 0, MOD = 1000000000;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K+1][N+1];
		// K = 1일 경우 항상 경우의 수는 1이다.
		Arrays.fill(dp[1], 1);
		// N = 0일 경우 항상 경우의 수는 1이다.
		for(int i = 1; i <= K; i++) dp[i][0] = 1;
		
		for(int i = 2; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				// DP의 점화식
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] %= MOD;
            }
		}
		System.out.println(dp[K][N]);
	}
}