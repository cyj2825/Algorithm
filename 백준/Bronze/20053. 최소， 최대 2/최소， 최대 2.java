import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] data;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			data = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				data[i] = x;
			}
			Arrays.sort(data);
			System.out.println(data[0] + " " + data[N-1]);
		}
		br.close();
	}
}