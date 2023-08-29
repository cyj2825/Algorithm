import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 다익스트라 사용
public class Main {
	static class Node {
		int vertex, cost;
		
		public Node(int vertex, int cost) {
			super();
			this.vertex = vertex;
			this.cost = cost;
		}
	}
	// 도시(정점)의 개수 N, 버스(간선)의 개수 M
	static int N, M, start, end;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		List<List<Node>> city = new ArrayList<>(N+1);
		
		for(int i = 0; i <= N; i++) {
			city.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			city.get(from).add(new Node(to, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		// 다익스트라 구현
		// PriorityQueue 정렬 기준 값 cost로 설정 
		Queue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		// 우선 시작점에 대한 값을 넣어준다
		pq.add(new Node(start, 0));
		// 각 정점마다 최소 비용 값을 넣어줄 배열 생성
		int[] distance = new int[N+1];
		// 큰값으로 초기화해줌
		Arrays.fill(distance, INF);
		// 시작점의 비용은 0으로 초기화
		distance[start] = 0;
		
		// 비용값은 시작점을 기준으로 정해짐
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			
			// 시작점에서 현재 curNode.vertex인 즉, 가리킴당하는 정점까지의 distance에 저장된 값이 해당 정점의 cost값보다 작다면 그 이후로 더 나아갈 필요없음
			if(distance[curNode.vertex] < curNode.cost) continue;
			
			for(Node nextNode : city.get(curNode.vertex)) {
				int c = curNode.cost + nextNode.cost;
				// 위의 정점과 연결된 그 다음 정점과의 비용합이 기존에 존재하는 비용값보다 작다면 갱신
				if(distance[nextNode.vertex] > c) {
					distance[nextNode.vertex] = c;
					pq.add(new Node(nextNode.vertex, c));
				}
			}
		}
		System.out.println(distance[end]);
		br.close();
	}
}