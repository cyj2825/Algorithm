import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		data = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오른쪽 방향으로의 연속 합을 구하는 dp1 배열
		int[] dp1 = new int[n];
		dp1[0] = data[0];
		
		int answer = dp1[0];
		// 오른쪽 방향으로 최대 연속 합을 각각 저장함 
		for(int i = 1; i < n; i++) {
			dp1[i] = Math.max(dp1[i-1] + data[i], data[i]);
			answer = Math.max(answer, dp1[i]);
		}
		
		// 왼쪽 방향으로의 연속 합을 구하는 dp2 배열
		int[] dp2 = new int[n];
		dp2[n-1] = data[n-1];
		// 왼쪽 방향으로 최대 연속 합을 각각 저장함 
		for(int i = n-2; i >= 0; i--) {
			dp2[i] = Math.max(dp2[i+1] + data[i], data[i]);
		}
		
		// 특정 값을 지웠다고 가정하고, 그 값의 오른쪽 방향과 왼쪽 방향의 최대 연속 합을 더함
		// 구한 값과 answer를 비교하여 더 큰 값으로 갱신
		for(int i = 1; i < n - 1; i++) {
			int temp = dp1[i-1] + dp2[i+1];
			answer = Math.max(answer, temp);
		}
		System.out.println(answer);
		br.close();
	}
}