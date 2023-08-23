import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	// 부모를 저장하는 배열
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// n+1개의 집합, 입력으로 주어지는 연산의 개수 m
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		make();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int val = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(val == 0) union(a, b);
			else if(val == 1) {
				if(find(a) == find(b)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
	
	// 초기화
	public static void make() {
		parents = new int[n+1];
		for(int i = 0; i <= n; i++) {
			// 원소 자신을 root임을 표시하기 위해 -1을 설정한다
			parents[i] = -1;
		}
	}
	
	// 특정 원소가 어떤 집합에 속해 있는지 부모를 찾는 함수
	public static int find(int a) {
		if(parents[a] < 0) return a;
		return parents[a] = find(parents[a]);
	}
	
	// a가 포함되어 있는 집합과 b가 포함되어 있는 집합을 합치는 함수
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		// 서로의 대표자가 같은 즉, 같은 집합의 상황이므로 union하지 않음
		if(aRoot == bRoot) return false;
		
		int aRank = parents[aRoot];
		int bRank = parents[bRoot];
		
		if(aRank == bRank) {
			parents[aRoot]--;
			parents[bRoot] = aRoot;
		}else if(aRank < bRank) {
			parents[bRoot] = aRoot;
		}else {
			parents[aRoot] = bRoot;
		}
		return true;
	}
}