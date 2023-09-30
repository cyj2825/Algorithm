import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();
	static int l1, l2;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		l1 = s1.length();
		l2 = s2.length();
		dp = new int[l1+1][l2+1];
		
		LCS(s1, s2);
		LCSToString(s1, l1, l2);
		System.out.println(sb.toString());
	}
	
	public static void LCS(String s1, String s2) {
		
		for(int i = 1; i < l1 + 1; i++) {
			for(int j = 1; j < l2 + 1; j++) {
				// s1의 문자열 i번째 문자와 s2의 문자열 j번째 문자가 같을 경우
				// ex) ACAYKP, CAPCAK => i=3, j=2 일 때,
				// ( AC C 의 LCS : dp[2][1] = 1 ) + 1  = 2
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				// 다를 경우
				// ex) ACAYKP, CAPCAK => i=3, j=3 일 때,  
				// (AC CAP의 LCS : dp[2][3] = 1)  vs (ACA CA dp[3][2] = 2) -> 2
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		sb.append(dp[l1][l2] + "\n");
	}
	
	public static void LCSToString(String s, int i , int j) {
		Stack<Character> stack = new Stack<>();
		
		// dp 값이 줄어드는 구간 찾기
		while(i > 0 && j > 0) {
			if(i == 0 || j == 0) break;
			
			if(dp[i][j] == dp[i-1][j]) i--;
			else if(dp[i][j] == dp[i][j-1]) j--;
			else {
				stack.push(s.charAt(i-1));
				i--;
				j--;
			}
		}
		
		while(!stack.isEmpty()) sb.append(stack.pop());
	}
}