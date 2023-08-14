import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, count;
	static char[][] data;
	static boolean flag;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		data = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String s = br.readLine();
			for(int j = 0; j < C; j++) {
				data[i][j] = s.charAt(j);
			}
		}
		count = 0;
		for(int i = 0; i < R; i++) {
			flag = false;
			dfs(i, 0);
		}
		System.out.println(count);
		
	}
	
	public static void dfs(int a, int b) {
		if(flag) {
			return;
		}
		data[a][b] = 'x';
		
		if(b == C-1) {
			count++;
			flag = true;
			return;
		}
		
		if(0 <= a-1 && a-1 < R && 0 <= b+1 && b+1 < C) {
			if(data[a-1][b+1] == '.') {
				dfs(a-1, b+1);
			}
		}
		if(0 <= a && a < R && 0 <= b+1 && b+1 < C) {
			if(data[a][b+1] == '.') {
				dfs(a, b+1);
			}
		}
		if(0 <= a+1 && a+1 < R && 0 <= b+1 && b+1 < C) {
			if(data[a+1][b+1] == '.') {
				dfs(a+1, b+1);
			}else {
				return;
			}
		}
	}
}