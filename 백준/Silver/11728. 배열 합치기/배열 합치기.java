import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 배열 A의 크기 n, 배열 B의 크기 m
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// 배열 A와 배열 B의 값 모두 넣기
		int[] result = new int[n+m];
		
		// 한줄 받아올 때마다 객체 생성
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			result[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = n; i < m+n; i++) {
			result[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(result);
		
		// 그냥 result값 하나하나 출력하는 System.out.println(x);하면 시간 초과 발생
		// StringBuilder로 값을 다 받고 한 번에 출력하는 것이 훨씬 빠르다
		StringBuilder sb = new StringBuilder();
		for(int x : result) {
			sb.append(x+" "); 			
		}
		System.out.println(sb);
	}
}