import java.io.*;
import java.util.*;

public class Main {
	public static class Node{
		int node, cost;
		public Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
	}
	
	static int N, M, s, e, answer = 0;
	static ArrayList<Node> list[];
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			max = Math.max(C, max);
			min = Math.min(C, min);
			list[A].add(new Node(B, C));
			list[B].add(new Node(A, C));
		}
		
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		while(min <= max) {
			int mid = (min + max) / 2;
			visited = new boolean[N+1];
			
			// s부터 e까지 mid의 중량이 건널 수 있는지 확인하는 것
			if(bfs(mid)) {
				min = mid + 1;
				answer = mid;
			} else {
				max = mid - 1;
			}
		}
		System.out.println(answer);
	}
	
	public static boolean bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
        // s부터 e까지 주어진 중량 x로 건널 수 있는지 확인해야 하므로 s 값으로 시작
		q.offer(s);
		visited[s] = true;
		
		while(!q.isEmpty()) {
			int data = q.poll();
			if(data == e) return true;
			
			for(int i = 0; i < list[data].size(); i++) {
				// 주어진 중량 x보다 크고 방문한 적이 없을 경우
				if(list[data].get(i).cost >= x && !visited[list[data].get(i).node]) {
					q.offer(list[data].get(i).node);
					visited[list[data].get(i).node] = true;
				}
			}
		}
		return false;
	}
}