import java.io.*;
import java.util.*;

// BFS와 비트마스킹
public class Main {
	static class Item{
        int y, x, cnt, item;
        public Item(int y, int x, int cnt, int item){
            this.y=y;
            this.x=x;
            this.cnt=cnt;
            this.item=item;
        }
    }

    // N : 높이, M : 너비, itemNum : 물건의 개수
    static int N, M, itemNum;
    static int[] dy = {-1,1,0,0}, dx={0,0,-1,1};
    static char[][] home;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        home = new char[N+1][M+1];
        visited = new boolean[N+1][M+1][(1 << 6)];
        int sy = 0, sx = 0;
        char index = '0';
        
        for(int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
            	home[i][j] = s.charAt(j - 1);
                if (home[i][j] == 'X') {
                	home[i][j] = index++;
                    itemNum++;
                } else if (home[i][j] == 'S') {
                    sy = i;
                    sx = j;
                }
            }
        }
        System.out.println(bfs(sy, sx));
    }
    
    static int bfs(int sy, int sx) {
        Queue<Item> q = new LinkedList<>();
        q.add(new Item(sy, sx, 0, 0));
        visited[sy][sx][0] = true;

        while(!q.isEmpty()){
        	Item it = q.poll();
            int y = it.y;
            int x = it.x;
            int cnt = it.cnt;
            int item = it.item;

            if(home[y][x] == 'E' && item == ((1 << itemNum) - 1)) return cnt;

            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                int nItem = 0;

                if(ny < 1 || nx < 1 || ny > N || nx > M || visited[ny][nx][item] || home[ny][nx] == '#') continue;

                if(home[ny][nx] >= '0' && home[ny][nx] <= '5'){
                    int num = home[ny][nx] - '0';
                    if( (item & (1 << num)) == 0){
                        nItem = item | (1 << num);
                        q.add(new Item(ny, nx, cnt + 1, nItem));
                        visited[ny][nx][nItem] = true;
                        continue;
                    }
                }
                visited[ny][nx][item] = true;
                q.add(new Item(ny, nx, cnt + 1, item));
            }
        }
        return 0;
    }
}