import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, maxVal;
    static char[][] board;
    static int[] dx, dy;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		visited = new boolean[26];
		maxVal = 0;
		// 상하좌우 이동
		dx = new int[] {-1, 1, 0, 0};
		dy = new int[] {0, 0, -1, 1};
        
		for(int i = 0; i < R; i++) {
			String s = br.readLine();
			for(int j = 0; j < C; j++) {
				board[i][j] = s.charAt(j);
			}
		}
        
		dfs(0, 0, 1);
        System.out.println(maxVal);
    }
    
    public static void dfs(int x, int y, int len) {
    	visited[board[x][y]-65] = true; 
    	maxVal = Math.max(maxVal, len);
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[board[nx][ny]-65]) {
            	dfs(nx, ny, len + 1);
                visited[board[nx][ny]-65] = false;
            }
        }
    }
}