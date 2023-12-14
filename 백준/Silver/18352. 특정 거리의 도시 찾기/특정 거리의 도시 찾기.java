import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, X;
	static ArrayList<Integer> city[];
	static ArrayList<Integer> answer = new ArrayList<>();
	static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		city = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			city[i] = new ArrayList<>();
		}
		distance = new int[N+1];
		Arrays.fill(distance, -1);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			city[x].add(y);
		}
		bfs(X);
		if(answer.isEmpty()) System.out.println(-1);
		else {
			Collections.sort(answer);
			StringBuilder sb = new StringBuilder();
			for(int x : answer) {
				sb.append(x + "\n");
			}
			System.out.println(sb);
		}
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(x);
		distance[x] = 0;
		
		while(!q.isEmpty()) {
			int data = q.poll();
			if(distance[data] > K) break;
			if(distance[data] == K) answer.add(data);
			
			for(int next : city[data]) {
				if (distance[next] != -1) continue;
				distance[next] = distance[data] + 1;
				q.offer(next);
			}
		}
	}
}