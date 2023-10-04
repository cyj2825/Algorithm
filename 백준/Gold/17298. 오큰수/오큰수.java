import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] data;
	static Stack<Integer> s = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) data[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			
			// 스택이 비어있지 않으면 
			while(!s.isEmpty() && data[s.peek()] < data[i]) {
				data[s.pop()] = data[i];
			}
			
			s.push(i);
		}
		
		while(!s.isEmpty()) data[s.pop()] = -1;
		
		StringBuilder sb = new StringBuilder();
		for(int i : data) {
			sb.append(i + " ");
		}
		System.out.print(sb.toString());
	}
}