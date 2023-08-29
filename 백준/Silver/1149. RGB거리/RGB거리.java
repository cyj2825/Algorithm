import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] rgb;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		rgb = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i < N; i++) {
			// 빨간색을 선택했을 경우
			rgb[i][0] = Math.min(rgb[i-1][1], rgb[i-1][2]) + rgb[i][0];
			// 초록색을 선택했을 경우
			rgb[i][1] = Math.min(rgb[i-1][0], rgb[i-1][2]) + rgb[i][1];
			// 파란색을 선택했을 경우
			rgb[i][2] = Math.min(rgb[i-1][0], rgb[i-1][1]) + rgb[i][2];
		}
		
		int answer = Math.min(rgb[N-1][0], rgb[N-1][1]);
		answer = Math.min(answer, rgb[N-1][2]);
		System.out.println(answer);
	}
}
