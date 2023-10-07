import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, L;
	static Deque<int[]> dq = new ArrayDeque<int[]>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			while(!dq.isEmpty() && dq.peekLast()[0] > num) dq.pollLast();
			
			dq.offer(new int[] {num, i});
			if(dq.peek()[1] < i - (L-1)) dq.poll();
			
			sb.append(dq.peek()[0] + " ");
		}
		System.out.println(sb.toString());
		br.close();
	}
}