import java.io.*;
import java.util.*;

public class Main {
	static class Space{
		int x, y, cnt;
		
		public Space(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static int N, M, H, W, Sr, Sc, Fr, Fc;
	static int[][] board;
	// 상하좌우로 이동
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), "  ");
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Sr = Integer.parseInt(st.nextToken())-1;
		Sc = Integer.parseInt(st.nextToken())-1;
		Fr = Integer.parseInt(st.nextToken())-1;
		Fc = Integer.parseInt(st.nextToken())-1;
		
		System.out.println(bfs(Sr, Sc, Fr, Fc));
	}
	
	public static int bfs(int r, int c, int goalr, int goalc) {
		Queue<Space> q = new LinkedList<>();
		q.offer(new Space (r, c, 0));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Space data = q.poll();
			int x = data.x;
			int y = data.y;
			
			// 만약 도착 위치에 오면 지금까지 센 이동 횟수를 return
			if(x == goalr && y == goalc) return data.cnt;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
				
				if(!isPossible(nx, ny)) continue;
				
				q.offer(new Space(nx, ny, data.cnt+1));
				visited[nx][ny] = true;
			}
		}
		return -1;
	}
	
	public static boolean isPossible(int x, int y) {
		for(int i = x; i < x + H; i++) {
			for(int j = y; j < y + W; j++) {
				if(i < 0 || i >= N || j < 0 || j >= M || board[i][j] == 1) return false;
			}
		}
		return true;
	}
}