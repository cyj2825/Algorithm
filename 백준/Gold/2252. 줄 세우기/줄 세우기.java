import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] inDegree;
	static ArrayList<Integer>[] list;
	static ArrayList<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>(); //인접 정보를 담을 list를 생성 
		}
		inDegree = new int[N+1];
		int node, ad;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			node = Integer.parseInt(st.nextToken());
			ad = Integer.parseInt(st.nextToken());
			list[node].add(ad);					//node에 인접정보(ad)를 추가한다. 
			inDegree[ad]++;
		}
		result = topologySort();
		StringBuilder sb = new StringBuilder();
		for(int x : result) {
			sb.append(x + " ");
		}
		System.out.println(sb);
	}
	
	private static ArrayList<Integer> topologySort() {
		ArrayList<Integer> orderList = new ArrayList<>();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <=N; ++i) {
			if(inDegree[i]==0) q.offer(i);
		}
		 
		while(!q.isEmpty()) {
			int cur = q.poll();
			orderList.add(cur);
			
			for(int i = 0; i < list[cur].size(); i++) {
				if(--inDegree[list[cur].get(i)]==0) q.offer(list[cur].get(i));
			}
		}
		return orderList;
	}
}