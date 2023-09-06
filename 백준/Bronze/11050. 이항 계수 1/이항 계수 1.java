import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, count;
	static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new int[N];
		combination(0, 0);
		System.out.println(count);
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == K) {
			count++;
			return;
		}
		for(int i = start; i < N; i++) {
			data[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
}