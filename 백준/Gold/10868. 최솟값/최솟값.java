import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static long[] arr;    // 원소를 저장하는 배열
	static long[] tree;   // SGtree
	
	// 원소를 이용해서 SGtree를 구성하는 함수
	public static long init(int node, int start, int end) {
		// 단말 노드
		if(start == end) {
			return tree[node] = arr[start];   // 원소의 값을 노드에 저장
		}
		else {
			// 하위 노드의 값을 더해서 저장
			int mid = (start+end)/2;
			int nn = node * 2;
			// 해당 노드에 왼쪽 자식 노드 + 오른쪽 자식 노드를 연결
			return tree[node] = Math.min(init(nn, start, mid), init(nn+1, mid+1, end));
		}
	}
	
	// left ~ right 범위 내에 최솟값을 찾음
	public static long find(int node, int start, int end, int left, int right) {
		// 범위를 벗어난 경우
		if(right < start || end < left) {
			return Integer.MAX_VALUE;
		}
		
		// 범위 안에 있는 경우
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		int nn = node * 2;
		return Math.min(find(nn, start, mid, left, right), find(nn+1, mid+1, end, left, right));
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값이 크면 BufferedWriter 사용하는 것이 좋음
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 구분자 " " 넣어주는 것이 좋음 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new long[N+1];
		tree = new long[N << 2];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		init(1, 1, N);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			sb.append(find(1, 1, N, left, right) + "\n");
		}
		System.out.println(sb.toString());
	}

}
