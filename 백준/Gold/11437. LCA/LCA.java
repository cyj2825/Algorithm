import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// LCA
public class Main {
	// 노드의 개수 N, 가장 가까운 공통 조상을 알고 싶은 쌍의 개수 M
	static int N, M;
	static int[] parents, depth;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		depth = new int[N+1];
		list = new ArrayList[N+1];
		
		for(int i = 1; i <=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		init(1, 0, -1);
		
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			LCA(a, b);
		}
	}
	
	public static void init(int cur, int h, int p) {
		depth[cur] = h;
		parents[cur] = p;
		for(int nextV : list[cur]) {
			if(nextV != p) {
				init(nextV, h+1, cur);
			}
		}
	}
	
	public static void LCA(int a, int b) {
		int ah = depth[a];
		int bh = depth[b];
		
		while(ah > bh) {
			a = parents[a];
			ah--;
		}
		
		while(bh > ah) {
			b = parents[b];
			bh--;
		}
		
		while(a!=b) {
			a = parents[a];
			b = parents[b];
		}
		System.out.println(a);
	}
}