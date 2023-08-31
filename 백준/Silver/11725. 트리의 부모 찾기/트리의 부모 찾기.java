import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] parents;
	static List<Integer>[] tree;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		parents = new int[N+1];
		for(int i = 0; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tree[s].add(e);
			tree[e].add(s);
		}
		
		for(int i = 0; i < tree[1].size(); i++) {
			int x = tree[1].get(i);
			parents[x] = 1;
			dfs(x);
		}
		
		for(int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
		
	}
	public static void dfs(int a) {
		for(int i = 0; i < tree[a].size(); i++) {
			int x = tree[a].get(i);
			if(parents[x] == 0) {
				parents[x] = a;
				dfs(x);
			}
		}
	}
}