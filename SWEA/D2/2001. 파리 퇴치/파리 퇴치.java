import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static int n, m;
	static int[][] data;
	static int maxVal;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			data = new int[n][n];
			maxVal = 0;
			
			for(int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					data[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 가능한 M*M의 시작점은 (0,0)부터 (n-m,n-m)까지임
			for(int j = 0; j < n-m+1; j++) {
				for (int k = 0; k < n-m+1; k++) {
					int sumVal = 0;
					// 가능한 시작점부터 M*M 크기의 사각형에 포함되는 값들의 합 구하기
					for(int l = j; l < j+m; l++) {
						for(int o = k; o < k+m; o++) {
							sumVal += data[l][o];
						}
					}
					if (sumVal > maxVal) maxVal = sumVal;
				}
			}
			System.out.printf("#%d %d\n", i, maxVal);
		}
	}
}