import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, r, c, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		answer = 0;
		// N*N
		find(r, c, 1 << N);
		System.out.println(answer);
	}
	// r,c가 어느 사분면에 속하는지 구하는 함수
	private static void find(int R, int C, int size) {
		// size가 1이면 재귀 종료
		if(size == 1) return;
		
		int findSize = size/2;
		
		// r과 c가 1사분면에 속하는지
		if(R < findSize && C < findSize) {
			find(R, C, findSize);
		}
		// r과 c가 2사분면에 속하는지
		// 1사분면 방문
		else if(R < findSize && C >= findSize) {
			answer += (size * size) / 4;
			find(R, C - findSize, findSize);
		}
		// r과 c가 3사분면에 속하는지
		// 1, 2사분면 방문
		else if(R >= findSize && C < findSize) {
			answer += (size * size / 4) * 2;
			find(R - findSize, C, findSize);
		}
		// r과 c가 4사분면에 속하는지
		// 1, 2, 3사분면 방문
		else {
			answer += (size * size / 4) * 3;
			find(R - findSize, C - findSize, findSize);
		}
	}
}