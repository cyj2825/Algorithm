import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int x, y, weight;
		
		public Node(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	private static final int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] cave;
	static int[][] dijk;
	// 상, 하, 좌, 우로 이동
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int count = 0;
		
		while (N != 0) {
			cave = new int[N][N];
			dijk = new int[N][N];
			
			// 동굴 값 입력받기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					dijk[i][j] = INF;
				}
			}
			int answer = dijkstra();
			count++;
			System.out.println("Problem " + count + ": " + answer);
			N = Integer.parseInt(br.readLine());
		}
	}
	
	public static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0, cave[0][0]));
		dijk[0][0] = cave[0][0];
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int curX = curNode.x;
			int curY = curNode.y;
			
			for(int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if(0 <= nx && nx < N && 0 <= ny && ny < N) {
					if(dijk[nx][ny] > dijk[curX][curY] + cave[nx][ny]) {
						dijk[nx][ny] = dijk[curX][curY] + cave[nx][ny];
						pq.add(new Node(nx, ny, dijk[nx][ny]));
					}
				} 
			}
		}
		return dijk[N-1][N-1];
	}
}