import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] index = new int[n];
		int[] data = new int[n];
		Stack<Integer> s = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx;
		for (int i = n-1; 0 <= i; --i) {
			while (!s.isEmpty()) {
				idx = s.peek();
				if(data[i] >= data[idx]) {
					index[idx] = i + 1;
					s.pop();
				}
				else {
					break;
				}
			}
			s.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int a : index) {
			sb.append(a + " ");
		}
		System.out.println(sb.toString());
	}
}