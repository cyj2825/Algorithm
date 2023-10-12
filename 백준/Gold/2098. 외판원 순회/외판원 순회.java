import java.io.*;
import java.util.*;

public class Main {
	static int N, INF = 16000000;
	static int[][] W;
	static int[][] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[N][(1<<N)-1];
		for(int i = 0; i < N; i++) Arrays.fill(dp[i], -1);
		System.out.println(dfs(0, 1));
	}
	
	private static int dfs(int cur, int visit) {
		// 모든 도시 방문
		if(visit == (1<<N)-1) {
			// 맨 처음 도시로 돌아가는 값이 0일 경우
			if(W[cur][0] == 0) return INF;
			return W[cur][0];
		}
		
		if(dp[cur][visit] != -1) return dp[cur][visit];
		dp[cur][visit] = INF;
		
		for(int i = 0; i < N; i++) {
			if(W[cur][i] != 0 && (visit & (1<<i)) == 0) {
				dp[cur][visit] = Math.min(dp[cur][visit], dfs(i, visit | (1<<i)) + W[cur][i]);
			}
		}
		return dp[cur][visit];
	}
}