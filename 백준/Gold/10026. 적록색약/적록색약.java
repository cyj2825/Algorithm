import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int N, count, sickCount;
	static char[][] draw;
	static int[] dx, dy;
	static boolean[][] visited, sickVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		draw = new char[N][N];
		// 상하좌우 이동
		dx = new int[] {-1, 1, 0, 0};
		dy = new int[] {0, 0, -1, 1};
		visited = new boolean[N][N];
		sickVisited = new boolean[N][N];
		count = 0;
		sickCount = 0;
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				draw[i][j] = s.charAt(j);
			}
		}
		// 일반 사람
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i, j, draw[i][j]);
					count++;
				}
			}
		}
		// 적록 색약 사람
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!sickVisited[i][j]) {
					bfsSick(i, j, draw[i][j]);
					sickCount++;
				}
			}
		}
		System.out.println(count + " " + sickCount);
	}
	private static void bfs(int x, int y, char val) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {x, y, val});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] data = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = data[0] + dx[i];
				int ny = data[1] + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny] && draw[nx][ny] == val) {
					q.offer(new int[] {nx, ny, val});
					visited[nx][ny] = true;
				}
			}
		}
		
	}
	private static void bfsSick(int x, int y, char val) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {x, y, val});
		sickVisited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] data = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = data[0] + dx[i];
				int ny = data[1] + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < N && !sickVisited[nx][ny]) {
					if(val == 'R' || val == 'G') {
						if(draw[nx][ny] == 'R' || draw[nx][ny] == 'G') {
							q.offer(new int[] {nx, ny, draw[nx][ny]});
							sickVisited[nx][ny] = true;
						}
					}
					else if (val == 'B') {
						if(draw[nx][ny] == 'B') {
							q.offer(new int[] {nx, ny, draw[nx][ny]});
							sickVisited[nx][ny] = true;
						}
					}
				}
			}
		}
	}
}