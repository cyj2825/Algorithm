import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] home, fest;
	static List<int[]> store;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			home = new int[2];
			fest = new int[2];
			store = new ArrayList<int[]>();
			
			st = new StringTokenizer(br.readLine());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			
			// 편의점 좌표값 넣기
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				store.add(new int[] {x, y});
			}
			
			st = new StringTokenizer(br.readLine());
			fest[0] = Integer.parseInt(st.nextToken());
			fest[1] = Integer.parseInt(st.nextToken());
			
			if(distance(home, fest) <= 1000){
				System.out.println("happy");
				continue;
			}
			visited = new boolean[n];
			bfs();
		}
	}
	
	public static void bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(home);
		
		while(!q.isEmpty()) {
			int[] a = q.poll();
			if(distance(a, fest) <= 1000) {
				System.out.println("happy");
				return;
			}
			for(int i = 0; i < n; i++) {
				if(!visited[i]) {
					int x = store.get(i)[0];
					int y = store.get(i)[1];
					if(distance(a, new int[] {x, y}) <= 1000) {
						q.offer(new int[] {x, y});
						visited[i] = true;
					}
				}
			}
		}
		System.out.println("sad");
		return;
	}
	
	public static int distance(int[] a, int[] b) {
		return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
	}
}