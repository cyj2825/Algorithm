import java.io.*;
import java.util.*;

// 플로이드 워셜 문제!
public class Main {
	static int N, K, answer = Integer.MAX_VALUE;
	static int[][] time;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		time = new int[N][N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				time[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 플로이드 워셜 핵심 코드
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i == j) continue;
					time[i][j] = Math.min(time[i][j], time[i][k] + time[k][j]);
				}
			}
		}
		
		visited[K] = true;
		dfs(K, 0, 0);
		System.out.println(answer);
	}
	
	public static void dfs(int x, int depth, int sum) {
		if(depth == N-1) {
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, depth + 1, sum + time[x][i]);
				visited[i] = false;
			}
		}	
	}
}