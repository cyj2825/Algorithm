import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map, memo;
	// 상하좌우 이동
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		memo = new int[N][M];
		for(int i =0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				memo[i][j] = -1;
			}
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dfs(0, 0));
	}
	
	public static int dfs(int x, int y) {
		if(x == N-1 && y == M-1) {
			return 1;
		}
		if (memo[x][y] != -1) 
			return memo[x][y];
		
		memo[x][y] = 0;
		int H = map[x][y];
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 > nx || nx >= N || 0 > ny || ny >= M) continue;
			if(H > map[nx][ny]) {
				memo[x][y] += dfs(nx, ny);
			}
		}
		return memo[x][y];
	}
}