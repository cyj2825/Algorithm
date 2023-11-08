import java.io.*;
import java.util.*;

public class Main {
	static class MoveState {
		int x, y, cnt;
		boolean isGram;
		public MoveState(int x, int y, int cnt, boolean isGram) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.isGram = isGram;
		}
	}
	static int N, M, T, answer;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int[][] castle;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		castle = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				castle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 3차원의 값이 0이면 그람이 없을 때, 1이면 그람이 있을 때
		visited = new boolean[N][M][2];
		answer = bfs(0, 0);
		if(answer == -1) System.out.println("Fail");
		else System.out.println(answer);
	}
	
	public static int bfs(int x, int y) {
		Queue<MoveState> q = new ArrayDeque<>();
		q.offer(new MoveState(x, y, 0, false));
		visited[x][y][0] = true;
		
		while(!q.isEmpty()) {
			MoveState ms = q.poll();
			// 주어진 T초를 넘었을 경우 종료한다
			if(ms.cnt > T) break;
			if(ms.x == N-1 && ms.y == M-1) return ms.cnt;
			
			for(int i = 0; i < 4; i++) {
				int nx = ms.x + dx[i];
				int ny = ms.y + dy[i];
				
				if(nx < 0 || N <= nx || ny < 0 || M <= ny) continue;
				if(!ms.isGram) {
					if(castle[nx][ny] == 0 && !visited[nx][ny][0]) {
						visited[nx][ny][0] = true;
						q.offer(new MoveState(nx, ny, ms.cnt+1, ms.isGram));
					}
					else if(castle[nx][ny] == 2 && !visited[nx][ny][0]) {
						visited[nx][ny][0] = true;
                        q.offer(new MoveState(nx, ny, ms.cnt + 1, true));
                    }
				}
				else {
					if(!visited[nx][ny][1]) {
						visited[nx][ny][1] = true;
						q.offer(new MoveState(nx, ny, ms.cnt + 1, ms.isGram));
					}
				}
			}
		}
		return -1;
	}
}