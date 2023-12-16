import java.io.*;
import java.util.*;

public class Main {
	static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}	
	}
	static int R, C;
	static char[][] pasture;
	// 상하좌우 이동
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static Queue<Pair> wolf = new LinkedList<>();
	static boolean check = true;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		pasture = new char[R][C];
		for(int i = 0; i < R; i++) {
			String s = br.readLine();
			for(int j = 0; j < C; j++) {
				pasture[i][j] = s.charAt(j);
				if(pasture[i][j] == 'W') wolf.add(new Pair(i, j));
			}
		}
		bfs();

		if(check) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					sb.append(pasture[i][j]);
				}
				sb.append('\n');
			}
			System.out.println(1);
			System.out.println(sb);
		}
		else {
			System.out.println(0);
		}
	}
	
	public static void bfs() {
		while(!wolf.isEmpty()) {
			Pair data = wolf.poll();
			for(int i = 0; i < 4; i++) {
				int nx = data.x + dx[i];
				int ny = data.y + dy[i];
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if(pasture[nx][ny] == '.') pasture[nx][ny] = 'D';
				if(pasture[nx][ny] == 'S') {
					check = false;
					return;
				}
			}
		}
	}
}