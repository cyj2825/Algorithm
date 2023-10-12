import java.io.*;
import java.util.*;

public class Main {
	static int N, M, answer;
	static int[][] maze;
	// 상하좌우로 이동
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		visited = new boolean[N][M];
		answer = Integer.MAX_VALUE;
		
		// 미로 값 입력받기
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				maze[i][j] = s.charAt(j)-'0';
			}
		}
		bfs(0, 0);
		System.out.println(maze[N-1][M-1]);
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(!visited[nx][ny] && maze[nx][ny] == 1) {
					maze[nx][ny] = maze[cur[0]][cur[1]] + 1;
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
	}
}