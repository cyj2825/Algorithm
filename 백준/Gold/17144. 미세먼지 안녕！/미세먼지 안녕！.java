import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class dust {
		int x, y, value, plus;

		public dust(int x, int y, int value, int plus) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
			this.plus = plus;
		}
	}
	
	static int R, C, T;
	static dust[][] room;
	// 공기청정기 위치값 넣기
	static List<int[]> clean = new ArrayList<int[]>(2);
	// 상하좌우 이동
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		room = new dust[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				int v = Integer.parseInt(st.nextToken());
				room[i][j] = new dust(i, j, v, 0);
				// 공기청정기 위치 저장
				if(v == -1) clean.add(new int[] {i, j});
			}
		}
		
		// T초 동안 일 수행.
		for(int i = 0; i < T; i++) {
			spread();
			for(int j = 0; j < R; j++) {
				for(int k = 0; k < C; k++) {
					if(room[j][k].plus == 0) continue;
					room[j][k].value += room[j][k].plus;
					room[j][k].plus = 0;
				}
			}

			rotate();
		}
		
		int answer = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(room[i][j].value > 0) answer += room[i][j].value;
			}
		}
		System.out.println(answer);
	}
	
	// 미세먼지 확산하는 함수
	private static void spread() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				// 0보다 작거나 같으면 미세먼지가 존재하지 않거나 공기청정기 위치
				if(room[i][j].value <= 0) continue;
				
				// 0보다 크면 미세먼지가 있으므로 확산 진행
				// 상하좌우로 이동
				int cnt = 0;
				for(int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					// 범위에 있고 공기청정기 칸이 아닌 곳에서만 확산이 일어남
					if(0 <= nx && nx < R && 0 <= ny && ny < C && room[nx][ny].value != -1) {
						cnt ++;
						// 확산되는 위치의 미세먼지 양/5만큼 확산됨
						room[nx][ny].plus += room[i][j].value/5;
					}
				}
				room[i][j].value = room[i][j].value - (room[i][j].value/5) * cnt;
			}
		}
	}
	
	// 공기청정기 작동 후 회전하는 함수
	private static void rotate() {
		for(int i = 0; i < 2; i++) {
			int[] c = clean.get(i);
			
			// 반시계방향으로 이동
			if(i == 0) {
				dust t = room[c[0]][2];
				room[c[0]][2] = room[c[0]][1];
				room[c[0]][1] = new dust(0, 0, 0, 0);
				dust t2 = new dust(0, 0, 0, 0);
				// 오른쪽으로 끝까지 이동
				for(int j = 3; j < C; j++) {
					t2 = room[c[0]][j];					
					room[c[0]][j] = t;
					t = t2;
					
				}
				
				// 위로 끝까지 이동
				for(int j = c[0]-1; 0 <= j; j--) {
					t2 = room[j][C-1];
					room[j][C-1] = t;
					t = t2;
				}
				
				// 왼쪽으로 끝까지 이동
				for(int j = C-2; 0 <= j; j--) {
					t2 = room[0][j];
					room[0][j] = t;
					t = t2;
				}
				
				// 아래로 끝까지 이동
				for(int j = 1; j < c[0]; j++) {
					t2 = room[j][0];
					room[j][0] = t;
					t = t2;
				}
			}
			// 시계방향으로 이동
			else {
				dust t = room[c[0]][2];
				room[c[0]][2] = room[c[0]][1];
				room[c[0]][1] = new dust(0, 0, 0, 0);
				dust t2 = new dust(0, 0, 0, 0);
				// 오른쪽으로 끝까지 이동
				for(int j = 3; j < C; j++) {
					t2 = room[c[0]][j];
					room[c[0]][j] = t;
					t = t2;
				}
				
				// 아래로 끝까지 이동
				for(int j = c[0]+1; j < R; j++) {
					t2 = room[j][C-1];
					room[j][C-1] = t;
					t = t2;
				}
				
				// 왼쪽으로 끝까지 이동
				for(int j = C-2; 0 <= j; j--) {
					t2 = room[R-1][j];
					room[R-1][j] = t;
					t = t2;
				}
				
				// 위로 끝까지 이동
				for(int j = R-2; c[0] < j; j--) {
					t2 = room[j][0];
					room[j][0] = t;
					t = t2;
				}
			}
		}
	}
}