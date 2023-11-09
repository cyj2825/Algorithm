import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] data;
	static ArrayList<Integer> list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N+1];
		for(int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		
		list = new ArrayList<>();
		visited = new boolean[N+1];
		// 사이클을 이루는 값 찾기
		for(int i = 1; i <= N; i++) {
			visited[i] = true;
			dfs(i, i);
			visited[i] = false;
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) System.out.println(list.get(i));
	}
	
	public static void dfs(int s, int t) {
		if(visited[data[s]] == false) {
			visited[data[s]] = true;
			dfs(data[s], t);
			visited[data[s]] = false;
		}
		// 사이클 발견 시 list에 넣기
		if(data[s] == t) list.add(t);
	}
}