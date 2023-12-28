import java.io.*;
import java.util.*;

// 누적합과 비트마스킹 사용
public class Main {
	static long A, B, answer;
	// 입력의 최댓값인 10^16의 비트 길이는 54
	static long[] DP = new long[55];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		makeDP();
		answer = getValue(B) - getValue(A - 1);
		System.out.println(answer);
		br.close();
	}
	
	public static void makeDP() {
		DP[0] = 1;
		for(int i = 1; i < 55; i++) {
			DP[i] = DP[i-1] * 2 + (1L << i);
		}
	}
	
	public static long getValue(long x) {
		long result = x & 1;
		
		for(int i = 54; i > 0; i--) {
			// 숫자 x의 i번째 비트가 1이면
			if((x & (1L << i)) > 0L) {
				result += DP[i - 1] + (x - (1L << i) + 1);
				x -= (1L << i);
			}
		}
		return result;
	}
}