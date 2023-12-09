import java.io.*;
import java.util.*;

public class Main {
	static int W, H, answer;
	static int[][] map;
	static boolean[][] visited;
	static int[][] result;
	// H값이 홀수인지, 짝수인지에 따라 나눈다.
	// 좌, 좌상, 우상, 우, 우하, 좌하 순, 행과 열의 순서가 바뀐 것을 반영
	static int[][] odd = {{0, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}};
	static int[][] even = {{0, -1}, {-1, -1}, {-1, 0}, {0, 1}, {1, 0}, {1, -1}};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// H : 열, W : 행
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		// 외벽과 닿는 면을 한 칸 둘러싸기 위해 +2
		map = new int[W+2][H+2];
		visited = new boolean[W+2][H+2];
		result = new int[W+2][H+2];
		
		for(int i = 1; i <= W; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= H; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 벽이 존재하는지 여부를 판단하여 벽면 길이를 구할 것이므로 건물이 존재하는 위치는 미리 true값으로 변경
				if(map[i][j] == 1) visited[i][j] = true;
			}
		}
		
		bfs();
		for(int i = 0; i < W+2; i++) {
			for(int j = 0; j < H+2; j++) {
				answer += result[i][j];
			}
		}
		System.out.println(answer);
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {0, 0});
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] data = q.poll();
			for(int i = 0; i < 6; i++) {
				int nx = 0;
				int ny = 0;
				if(data[0] % 2 == 0) {
					nx = data[0] + even[i][0];
					ny = data[1] + even[i][1];
				}else {
					nx = data[0] + odd[i][0];
					ny = data[1] + odd[i][1];
				}
				
				if(nx < 0 || nx >= W + 2 || ny < 0 || ny >= H + 2) continue;
				// 건물이 존재하지 않는 값들을 기준으로 bfs를 진행하므로 값이 0인 위치에서 움직이면서 확인하며 
				if(map[nx][ny] == 1) {
					result[data[0]][data[1]] += 1;
					continue;
				}
				if(visited[nx][ny]) continue;
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
	}
}