import java.io.*;
import java.util.*;

public class Main {
	static int N, answer = 0;
	static boolean check;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			check = false;
			if(x > 1) {
				for(int j = 2; j <= (int) Math.sqrt(x); j++) {
					if(x % j == 0) {
						check = true;
						break;
					}
				}
				if(!check) answer++;
			}
		}
		System.out.println(answer);
	}
}