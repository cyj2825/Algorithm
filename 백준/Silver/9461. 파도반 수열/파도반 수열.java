import java.io.*;

public class Main {
	static int N;
	static Long[] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			dp = new Long[101];
			dp[1] = 1L;
			dp[2] = 1L;
			dp[3] = 1L;
			if(N > 3) {
				for(int i = 4; i <= 100; i++) {
					dp[i] = dp[i-2] + dp[i-3];
				}
			}
			System.out.println(dp[N]);
		}
	}
}