import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 조합론 + DP
public class Main {
	static int N, val;
	static long k;
	static long[] factorial;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// N 값이 1부터 20까지 가능하므로
		factorial = new long[21];
		visited = new boolean[21];
		
		// 팩토리얼 배열의 초기화를 모두 1값으로 준다
		Arrays.fill(factorial, 1);
		for(int i = 1; i <= 20; i++) {
			factorial[i] = factorial[i-1] * i;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		val = Integer.parseInt(st.nextToken());
		int[] data = new int[N];
		StringBuilder sb = new StringBuilder();
		
		// k번째의 수열 출력
		if (val == 1) {
			k = Long.parseLong(st.nextToken());
			
			// 팩토리얼 가짓수 치기
			for(int i = 0; i < N; i++) {
				// 1 ~ N 확인
				for(int j = 1; j <= N; j++) {
					// 순열에 이미 존재하는 숫자면 continue
					if(visited[j]) continue;
					
					// 팩토리얼 값이 k보다 작으면 k에서 팩토리얼 값을 빼준다
					if(factorial[N-i-1] < k) k -= factorial[N-i-1];
					else {
						// 팩토리얼 값이 k보다 크면 해당하는 원소의 숫자 찾은 것
						data[i] = j;
						visited[j] = true;
						break;
					}
				}
			}
			for (int i = 0; i < N; i++) sb.append(data[i] + " ");
		}
		// 입력받은 순열이 몇 번째인지 출력
		else if (val == 2) {
			for(int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			
			long idx = 1;
			for(int i = 0; i < N; i++) {
				for(int j = 1; j < data[i]; j++) {
					// 1부터 해당하는 원소까지 팩토리얼 값을 늘려가며 더해줌
					if(visited[j]) continue;
					
					idx += factorial[N-i-1];
				}
				// 순열에 존재하는 숫자 표시
				visited[data[i]] = true;
			}
			sb.append(idx);
		}
		System.out.println(sb.toString());
	}
}
