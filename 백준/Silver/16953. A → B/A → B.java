import java.io.*;
import java.util.*;

public class Main {
	static long A, B;
	static int answer = Integer.MAX_VALUE;
	static boolean check;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		dfs(A, 0);
		if(check) System.out.println(answer);
		else System.out.println(-1);
	}
	public static void dfs(long x, int cnt) {
		if(x == B) {
			check = true;
			answer = Math.min(answer, cnt+1);
			return;
		}
		if(x > B) {
			return;
		}
		dfs(x * 2, cnt + 1);
		dfs(x * 10 + 1, cnt + 1);
	}
}