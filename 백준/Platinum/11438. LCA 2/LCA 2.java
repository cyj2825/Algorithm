import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[] depth;
    private static int[][] parent;
    private static List<List<Integer>> graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		depth = new int[N+1];
		// 첫번째 []는 2^n 즉 100000값에 해당 -> 현재 정점에서 2^n만큼 위로 올라가 조상 노드 찾기
		// 두번째 []는 현재 
		parent = new int[18][N+1];
		graph = new ArrayList<>();
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		dfs(1, 1);
		fillParent();
		
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(query(a, b) + "\n");
		}
		
		bw.flush();
        bw.close();
        br.close();
	}
	
	// depth 배열을 생성하는 dfs
	private static void dfs(int cur, int d) {
		depth[cur] = d;
		
		for(int next: graph.get(cur)) {
			// 아직 depth가 구해지지 않았음
			if(depth[next] == 0) {
				// 직계부모는 cur
				parent[0][next] = cur;
				dfs(next, d+1);
			}
		}
	}
	
	private static void fillParent() {
		for(int i = 1; i <= 17; i++) {
			for(int j = 1; j <= N; j++) {
				parent[i][j] = parent[i-1][parent[i-1][j]];
			}
		}
	}
	
	private static int query(int a, int b) {
		int depthA = depth[a];
		int depthB = depth[b];
		
		// depth가 깊은 것을 A로
		if(depthA < depthB) {
			int temp = depthA;
			depthA = depthB;
			depthB = temp;
			
			temp = a;
			a = b;
			b = temp;
		}
		
		// 서로의 높이가 같도록
		for(int i = 17; i >= 0; i--) {
			int pow = 1 << i;
			if(depthA - pow >= depthB) {
				a = parent[i][a];
				depthA -= pow;
			}
			if(depthA == depthB) break;
		}
		
		int answer = a;
		if(a != b) {
			for(int i = 17; i >= 0; i--) {
				if(parent[i][a] != parent[i][b]) {
					a = parent[i][a];
					b = parent[i][b];
				}
				answer = parent[i][b];
			}
		}
		return answer;
	}
}