import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, d, k, c, maxCount, count;
	static int[] sushi, check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi = new int[N+k-1];
		check = new int[d+1];
		maxCount = 0;
		count = 0;
		
		for(int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		// sushi 배열 끝에 앞 쪽 k-1개를 뒤에 붙인다
	
		for(int i = 0; i < k-1; i++) {
			sushi[N++] = sushi[i];
		}
		
		// N번을 반복하면서 다음 집합은 이전 집합의 첫 원소를 빼는 처리 & 다음 원소를 추가
		for(int i = 0; i < N; i++) {
			if(check[sushi[i]] == 0) {
				count++;
			}
			check[sushi[i]]++;
			
			// k개가 되는 순간 초밥 가짓수 세기
			if(k-1 <= i) {
				if(k <= i) {
					if(check[sushi[i-k]] == 1) {
						count--;
					}
					check[sushi[i-k]]--;
				}
				
				// 쿠폰을 포함하고 있지 않다면 count값 증가
				if(check[c] == 0) {
					maxCount = Math.max(maxCount, count+1);
				}else {
					maxCount = Math.max(maxCount, count);
				}
			}
		}
		System.out.println(maxCount);
	}
}