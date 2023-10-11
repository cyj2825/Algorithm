import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs(0, 4, 0);
	}
	
	public static void dfs(int cnt, int n, int value) {
		if(cnt == N) {
			System.out.println(value);
			return;
		}
		
		if(cnt == 0) {
			dfs(1, 9, 2);
			dfs(1, 9, 3);
			dfs(1, 9, 5);
			dfs(1, 9, 7);
		}
		else {
			for(int i = 1; i <= n; i++) {
				if (prime(value*10 + i)) dfs(cnt+1, 9, value*10 + i);
			}
		}
	}
	
	// 소수가 맞는지 판별하는 함수
	public static boolean prime(int num) {
		for(int i = 2; i <= num/2; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
}