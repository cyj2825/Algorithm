import java.io.*;
import java.util.*;
 
public class Main {
    static int N, X;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			if (value < X)
				sb.append(value).append(' ');
		}
		System.out.println(sb);
	}
}