import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C, count;
	static char[][] map;
	static List<Pair> water;
	static int[] dx, dy;
	static boolean[][] visited;
	
	private static class Pair{
		int x, y, t;
		boolean flag;
		
		public Pair(int x, int y, int t, boolean flag) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
			this.flag = flag;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		water = new ArrayList<>();
		Pair ps = null;
		visited = new boolean[R][C];
		// 상하좌우 이동
		dx = new int[] {-1, 1, 0, 0};
		dy = new int[] {0, 0, -1, 1};		
		
		for(int i = 0; i < R; i++) {
			String s = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == 'S') {
					ps = new Pair(i, j, 0, true);
				}
				else if(map[i][j] == '*') {
					water.add(new Pair(i, j, 0, false));
				}
			}
		}
		bfs(water, ps);
		if(count == 0) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(count);
		}
	}
	
	private static void bfs(List<Pair> w, Pair ps) {
		Queue<Pair> q = new ArrayDeque<>();
		for(int i = 0; i < w.size(); i++) {
			q.offer(w.get(i));
			visited[w.get(i).x][w.get(i).y] = true;
		}
		q.offer(ps);
		visited[ps.x][ps.y] = true;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(!p.flag) {
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if(0 <= nx && nx < R && 0 <= ny && ny < C && !visited[nx][ny] && map[nx][ny] != 'D' && map[nx][ny] != 'X') {
						map[nx][ny] = '*';
						q.offer(new Pair(nx, ny, 0, false));
						visited[nx][ny] = true;
					}
				}
			}
			else {
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if(0 <= nx && nx < R && 0 <= ny && ny < C && !visited[nx][ny] && map[nx][ny] != 'X') {
						if(map[nx][ny] == '.') {
							map[nx][ny] = 'S';
							q.offer(new Pair(nx, ny, p.t+1, true));
							visited[nx][ny] = true;
						}
						else if(map[nx][ny] == 'D') {
							count = p.t + 1;
							return;
						}
					}
				}
			}
		}
	}
}