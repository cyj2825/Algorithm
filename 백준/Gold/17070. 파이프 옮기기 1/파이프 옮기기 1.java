import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, count;
	static int[][] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		count = 0;
		data = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(1, 0, 1);
		System.out.println(count);
	}
	
	// state값 1일 경우 가로, 2일 경우 세로, 3일 경우 대각선
	public static void dfs(int state, int x, int y) {
		if(x == n-1 && y == n-1) {
			count++;
			return;
		}
		if(state == 1) {
			if(check(1, x, y)) dfs(1, x, y+1);
			if(check(3, x, y)) dfs(3, x+1, y+1);
		}
		else if(state == 2) {
			if(check(2, x, y)) dfs(2, x+1, y);
			if(check(3, x, y)) dfs(3, x+1, y+1);
		}else {
			if(check(1, x, y)) dfs(1, x, y+1);
			if(check(2, x, y)) dfs(2, x+1, y);
			if(check(3, x, y)) dfs(3, x+1, y+1);
		}
	}
	
	public static boolean check(int state, int x, int y) {
		if(state == 1) {
			if(0<= y+1 && y+1 < n && data[x][y+1] == 0) return true;
		}
		else if(state == 2) {
			if(0<= x+1 && x+1 < n && data[x+1][y] == 0) return true;
		}
		else if(state == 3) {
			if(0<= x+1 && x+1 < n && 0<= y+1 && y+1 < n && data[x][y+1] == 0 && data[x+1][y] == 0 && data[x+1][y+1] == 0) return true;
		}
		return false;
	}
}
