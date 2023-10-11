import java.io.*;
import java.util.*;

public class Main {
	static int N, M, check;
	static ArrayList<Integer>[] list;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 사람 수 N, 친구 관계 수 M
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 0; i < N; i++) {
			visited = new boolean[N];
			if(dfs(i, 1)) {
				System.out.println(1);
				System.exit(0);
			}
		}
		System.out.println(0);
		br.close();
	}
	
	public static boolean dfs(int cur, int cnt) {
		visited[cur] = true;
		if(cnt == 5) return true;
		
		for(int i = 0, end = list[cur].size(); i < end; i++) {
			int ad = list[cur].get(i);
			if(!visited[ad]) {
				if(dfs(ad, cnt+1)) return true;
				else visited[ad] = false;
			}
		}
		return false;
	}
}