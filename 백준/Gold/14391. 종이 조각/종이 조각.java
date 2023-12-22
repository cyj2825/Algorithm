import java.io.*;
import java.util.*;

// 비트마스킹 -> 다시 풀어보기
// 임의의 칸 (x, y)가 0일 때 가로 조각, 1일 때 세로 조각
// 1 << (N * M) 연산으로 모든 가로 조각과 세로 조각 조합의 경우의 수를 구할 수 있음
public class Main {
	static int N, M, paper[][], answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				paper[i][j] = s.charAt(j) - '0';
			}
		}

		for (int c = 0; c < (1 << (N * M)); c++) {
			int sum = 0;

			// 0 값인 가로 찾기
			for (int i = 0; i < N; i++) {
				int value = 0;
				for (int j = 0; j < M; j++) {
					int k = i * M + j;
					// c의 k번째 비트가 0이면 해당 숫자는 가로 조각
					if ((c & (1 << k)) == 0) {
						value *= 10;
						value += paper[i][j];
					}
					// 1일 경우는 세로 조각이므로 지금까지 구한 value를 sum에 더함!
					else {
						sum += value;
						value = 0;
					}
				}
				sum += value;
			}

			// 1 값인 새로 찾기
			for (int i = 0; i < M; i++) {
				int value = 0;
				for (int j = 0; j < N; j++) {
					int k = j * M + i;
					// c의 k번째 비트가 1이면 해당 숫자는 세로 조각
					if ((c & (1 << k)) != 0) {
						value *= 10;
						value += paper[j][i];
					}
					// 0일 경우는 가로 조각이므로 지금까지 구한 value를 sum에 더함!
					else {
						sum += value;
						value = 0;
					}
				}
				sum += value;
			}
			
			// 모든 경우의 수에서 가장 큰 값을 구해야 하므로
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	}
}