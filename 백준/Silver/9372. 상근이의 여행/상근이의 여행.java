import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] schedule;
	static int answer;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 국가의 수 N, 비행기의 종류 M
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			schedule = new ArrayList[N+1];
			for(int i = 1; i <= N; i++) {
				schedule[i] = new ArrayList<>();
			}
			visited = new boolean[N+1];
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				schedule[a].add(b);
				schedule[b].add(a);
			}
			answer = 0;
			bfs(1);
			System.out.println(answer);
		}
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		visited[x] = true;
		
		while(!q.isEmpty()) {
			int data = q.poll();
			for(int next : schedule[data]) {
				if(!visited[next]) {
					answer++;
					q.offer(next);
					visited[next] = true;
				}
			}
		}
	}
}