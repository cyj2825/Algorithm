import java.io.*;
import java.util.*;

public class Main {
	static int R, C, N;
	// 상하좌우 이동
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[][] board;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		
		// 맨처음 초기값 넣어주기
		for(int i = 0; i < R; i++) {
			String s = br.readLine();
			for(int j = 0; j < C; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		// 1초에는 아무것도 안하므로 2~N
		for(int i = 2; i <= N; i++) {
			if(i % 2 == 1) {
				// 설피한 폭탄 폭발
				for(int j = 0; j < R; j++) {
					for(int k = 0; k < C; k++) {
						if(board[j][k] == 'O') q.add(new int[] {j, k});
					}
				}
				for(char[] b : board) Arrays.fill(b, 'O');
				bfs();
			}
		}
		StringBuilder sb = new StringBuilder();
		
		if(N % 2 == 0) {
			for(char[] b: board) Arrays.fill(b, 'O');
		}
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			int[] data = q.poll();
			board[data[0]][data[1]] = '.';
			for(int i = 0; i < 4; i++) {
				int nx = data[0] + dx[i];
				int ny = data[1] + dy[i];
				if(nx < 0 || R <= nx || ny < 0 || C <= ny) continue;
				if(board[nx][ny] == 'O') board[nx][ny] = '.';
			}
		}
	}
}