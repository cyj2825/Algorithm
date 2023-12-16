import java.io.*;
import java.util.*;

public class Main {
	static class Path{
		int v, distance;
		public Path(int v, int distance) {
			this.v = v;
			this.distance = distance;
		}
	}
	static int N, M, S, E, answer;
	static ArrayList<Integer>[] path;
	static int[] route; // 경로 배열, route[v] = v와 연결된 정점 : S->E 간 후에 아직 방문한 적 없는 점으로만 E->S를 가야 하기 때문에 필요!
	static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		path = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			path[i] = new ArrayList<>();
		}
		route = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			path[a].add(b);
			path[b].add(a);
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 짧은 경로가 여러 개 존재할 경우 사전순으로 먼저 오는 것을 출력해야 하므로 미리 오름차순으로 정렬
		for(int i = 1; i <= N; i++) Collections.sort(path[i]);
		
		bfs(S, E);
		visited = new boolean[N+1];
		int v = route[E];
		// S->E 과정에서 방문한 곳 모두 방문 처리하기
		while(v > 0) {
			visited[v] = true;
			v = route[v];
		}
		visited[S] = false;
		bfs(E, S);
		System.out.println(answer);
	}
	
	public static void bfs(int x, int y) {
		Queue<Path> q = new LinkedList<>();
		q.offer(new Path(x, 0));
		visited[x] = true;
		
		while(!q.isEmpty()){
			Path data = q.poll();
			for(int i : path[data.v]) {
				if(!visited[i]) {
					visited[i] = true;
					route[i] = data.v;
					q.offer(new Path(i, data.distance + 1));
				}
				
				if(i == y) {
					answer += data.distance+1;
					return;
				}
			}
		}
	}
}