import java.io.*;
import java.util.*;

// 다이나믹 프로그래밍 + 슬라이딩 윈도우 사용
public class Main {
	static int N;
	static int[] maxDP = new int[3], minDP = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int a3 = Integer.parseInt(st.nextToken());
			
			if(i == 0) {
				maxDP[0] = minDP[0] = a1;
				maxDP[1] = minDP[1] = a2;
				maxDP[2] = minDP[2] = a3;
			}
			else {
				// 최댓값 구하기
				int beforeMax_0 = maxDP[0];
				int beforeMax_2 = maxDP[2];
				// 현재줄의 값들 -> maxDP, 다음줄의 값 -> a~
				maxDP[0] = Math.max(maxDP[0], maxDP[1]) + a1;
				maxDP[2] = Math.max(maxDP[1], maxDP[2]) + a3;
				maxDP[1] = Math.max(Math.max(beforeMax_0, maxDP[1]), beforeMax_2) + a2;
				
				// 최솟값 구하기
				int beforeMin_0 = minDP[0];
				int beforeMin_2 = minDP[2];
				// 현재줄의 값들 -> maxDP, 다음줄의 값 -> a~
				minDP[0] = Math.min(minDP[0], minDP[1]) + a1;
				minDP[2] = Math.min(minDP[1], minDP[2]) + a3;
				minDP[1] = Math.min(Math.min(beforeMin_0, minDP[1]), beforeMin_2) + a2;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(Math.max(maxDP[0], Math.max(maxDP[1], maxDP[2])) + " ");
		sb.append(Math.min(minDP[0], Math.min(minDP[1], minDP[2])));
		System.out.println(sb);
		br.close();
	}
}