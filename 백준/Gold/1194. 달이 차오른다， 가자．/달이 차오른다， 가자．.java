import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pair {
		int x, y, cnt, flag;

		public Pair(int x, int y, int cnt, int flag) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.flag = flag;
		}
	}
	
	static int N, M, answer;
	// 행, 열, 키 값
	static char[][] maze;
	static boolean[][][] visited;
	// 상, 하, 좌, 우 이동
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new char[N][M];
		// a~f 키 존재 여부에 따른 visited 변경 위해 3차원 배열
		visited = new boolean[N][M][64];
		int x = 0;
		int y = 0;
		answer = -1;
		
		// 미로값 입력받기
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				maze[i][j] = s.charAt(j);
				if(maze[i][j] == '0') {
					x = i;
					y = j;
				}
			}
		}
		
		bfs(new Pair(x, y, 0, 0));
		System.out.println(answer);
	}
	
	public static void bfs(Pair p) {
		Queue<Pair> q = new ArrayDeque<>();
		q.offer(p);
		visited[p.x][p.y][p.flag] = true;
		
		while(!q.isEmpty()) {
			Pair pp = q.poll();

			for(int i = 0; i < 4; i++) {
				int nx = pp.x + dx[i];
				int ny = pp.y + dy[i];
				
				if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny][pp.flag]) {
					// 1을 발견할 경우 미로 탈출!
					if(maze[nx][ny] == '1') {
						answer = pp.cnt + 1;
						return;
					}
					
					if(maze[nx][ny] != '#') {
						
						if(maze[nx][ny] == 'a' || maze[nx][ny] == 'b' || maze[nx][ny] == 'c' || maze[nx][ny] == 'd' || maze[nx][ny] == 'e' || maze[nx][ny] == 'f') {
							q.offer(new Pair(nx, ny, pp.cnt+1, pp.flag | (1 << (maze[nx][ny] - 'a'))));
							visited[nx][ny][pp.flag] = true;
						}
						else if(maze[nx][ny] == 'A' || maze[nx][ny] == 'B' || maze[nx][ny] == 'C' || maze[nx][ny] == 'D' || maze[nx][ny] == 'E' || maze[nx][ny] == 'F') {
							if((pp.flag & (1 << (maze[nx][ny] -'A'))) != 0) {
								q.offer(new Pair(nx, ny, pp.cnt + 1, pp.flag));
								visited[nx][ny][pp.flag] = true;
							}
						}
						else {
							q.offer(new Pair(nx, ny, pp.cnt + 1, pp.flag));
							visited[nx][ny][pp.flag] = true;
						}
					}
				}
			}
		}
	}
}