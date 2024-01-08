import java.io.*;
import java.util.*;

public class Main {
	static int T, K;
	// dp[i][j] -> i부터 j까지 합쳤을 때의 값
	// dp[i][i] = data[i]
	static int data[], sum[], dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for(int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			data = new int[K+1];
			sum = new int[K+1];
			dp = new int[K+1][K+1];
			st = new StringTokenizer(br.readLine());
			
			for(int i = 1; i <= K; i++) {
				data[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i-1] + data[i];
			}
			for (int i = 1; i <= K; i++) {
                for (int s = 1; s + i <= K; s++) {
                    int e = s + i;
                    dp[s][e] = Integer.MAX_VALUE;
                    for (int j = s; j < e; j++) {
                        dp[s][e] = Math.min(dp[s][e], dp[s][j] + dp[j + 1][e] + sum[e] - sum[s - 1]);
                    }
                }
            }
            System.out.println(dp[1][K]);
		}
	}
}