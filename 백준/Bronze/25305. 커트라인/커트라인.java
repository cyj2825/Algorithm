import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static Integer[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(data, Collections.reverseOrder());
		
		System.out.println(data[K-1]);
	}
}