import java.io.*;
import java.util.*;

// 위상정렬 사용
public class Main {
	static int T, N, K, W;
	static int[] build, inDegree, cost;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			build = new int[N+1];
			list = new ArrayList[N+1];
			for(int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			
			// 건물당 건설에 걸리는 시간
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= N; i++) {
				build[i] = Integer.parseInt(st.nextToken());
			}
			
			inDegree = new int[N+1];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				list[X].add(Y);
				inDegree[Y]++;
			}
			W = Integer.parseInt(br.readLine());
			cost = new int[N+1];
			topologySort();
			System.out.println(cost[W]);
		}
	}
	private static void topologySort() {
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; ++i) {
			if(inDegree[i] == 0) {
				cost[i] = build[i];
				q.offer(i);
			}
		}
		 
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i = 0; i < list[cur].size(); i++) {
				int next = list[cur].get(i);
                cost[next] = Math.max(cost[cur] + build[next], cost[next]);
                if(--inDegree[next] == 0) q.offer(next);
			}
		}
	}
}