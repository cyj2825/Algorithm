import java.io.*;
import java.util.*;

public class Main {
	static class Pair{
		int x, time;

		public Pair(int x, int time) {
			super();
			this.x = x;
			this.time = time;
		}
	}
	static int N, K;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;
	static int max = 100000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[max+1];
		bfs();
		System.out.println(answer);
	}
	
	public static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(N, 0));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			visited[p.x] = true;
			if(p.x == K) answer = Math.min(answer, p.time);
			
			if(p.x * 2 <= max && !visited[p.x * 2]) q.offer(new Pair(p.x * 2, p.time));
			if(p.x + 1 <= max && !visited[p.x + 1]) q.offer(new Pair(p.x + 1, p.time + 1));
			if(p.x - 1 >= 0 && !visited[p.x - 1]) q.offer(new Pair(p.x - 1, p.time + 1));
		}
	}
}