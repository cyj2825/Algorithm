import java.io.*;
import java.util.*;

public class Main {
	static int A, B, T;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			System.out.printf("Case #%d: %d + %d = %d", t, A, B, A + B);
			System.out.println();
		}
	}
}