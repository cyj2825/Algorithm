import java.io.*;
import java.util.*;

public class Main {
	static class Point{
		int to, distance;
		
		public Point(int to, int distance) {
			super();
			this.to = to;
			this.distance = distance;
		}

		@Override
		public String toString() {
			return "Point [to=" + to + ", distance=" + distance + "]";
		}
		
	}
	static int V, result, x;
	static ArrayList<Point>[] tree;
	static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		V = Integer.parseInt(br.readLine());
		tree = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			tree[i] = new ArrayList<>();
		}
		
		// 트리 정보 입력받기
		for(int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			while(true) {
				int to = Integer.parseInt(st.nextToken());
				if(to == -1) break;
				int dist = Integer.parseInt(st.nextToken());
				tree[p].add(new Point(to, dist));
			}
		}
		result = 0;
		visited = new boolean[V+1];
		// 임의의 한 점에서 시작해서 끝까지 탐색, 그리고 마지막에 도달한 점에서 다시 dfs를 탐색하여 끝까지 탐색
		dfs(1, 0);
		visited = new boolean[V+1];
		result = 0;
		dfs(x, 0);
		System.out.println(result);
	}
	
	private static void dfs(int cur, int value) {
		visited[cur] = true;
		if(tree[cur].size() == 1 && visited[tree[cur].get(0).to]) {
			
			if(result < value) {
				result = value;
				x = cur;
			}
			return;
		}
		
		for(int i = 0, end = tree[cur].size(); i < end; i++) {
			Point ad = tree[cur].get(i);
			if(!visited[ad.to]) {
				dfs(ad.to, value + ad.distance);
				visited[ad.to] = false;
			}
		}
	}
}