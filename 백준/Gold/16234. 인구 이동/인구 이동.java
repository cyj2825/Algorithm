import java.io.*;
import java.util.*;

public class Main {
	static int N, L, R, cnt, value, answer;
	static int[][] data;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	static List<int[]> list;
	static boolean check;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		data = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			visited = new boolean[N][N];
			check = false;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						list = new ArrayList<int[]>();
						cnt = 1;
						value = data[i][j];
						bfs(i, j);
						if(cnt != 1) {
							int change = value/cnt;
							check = true;
							for(int[] l : list) {
								data[l[0]][l[1]] = change;
							}
						}
					}
				}
			}
			if(!check) {
				System.out.println(answer);
				return;
			}
			answer++;
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		list.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if(nx < 0 || N <= nx || ny < 0 || N <= ny) continue;
				if(!visited[nx][ny] && (L <= Math.abs(data[tmp[0]][tmp[1]] - data[nx][ny]) && Math.abs(data[tmp[0]][tmp[1]] - data[nx][ny]) <= R)) {
					cnt++;
					value += data[nx][ny];
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					list.add(new int[] {nx, ny});
				}
			}
		}
	}
}