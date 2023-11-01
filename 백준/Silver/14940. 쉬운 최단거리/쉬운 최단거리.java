import java.util.*;
import java.io.*;

public class Main {
	static int n, m, x, y;
	static int[][] give, answer;
	static boolean[][] visited;
	// 상하좌우로 이동 
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		give = new int[n][m];
		answer = new int[n][m];
		visited = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			Arrays.fill(answer[i], -1);
		}
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				give[i][j] = Integer.parseInt(st.nextToken());
				if(give[i][j] == 2) {
					x = i;
					y = j;
				}
				if(give[i][j] == 0) answer[i][j] = 0;
			}
		}
		
		bfs(x, y);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				sb.append(answer[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs(int bx, int by) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {bx, by});
		visited[bx][by] = true;
		answer[bx][by] = 0;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if(0 > nx || n <= nx || 0 > ny || m <= ny) continue;
				if(give[nx][ny] == 1 && !visited[nx][ny]) {
					answer[nx][ny] = answer[tmp[0]][tmp[1]] + 1;
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
}