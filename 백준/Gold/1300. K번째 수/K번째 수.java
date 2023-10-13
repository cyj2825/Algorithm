import java.io.*;

public class Main {
	static int N, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		// x는 start <= x <= end의 범위를 갖는다
		long start = 1;
		long end = k;
		
		// lower-bound
		while(start < end) {
			long mid = (start + end) / 2;
			long count = 0;
			
			// 임의의 x에 대해 i번째 행을 나눔으로써 x보다 작거나 같은 원소의 개수 누적 합을 구한다
			// 각 행의 원소의 개수가 N(열의 개수)를 초과하지 않는 선에서 합해야 함
			for(int i = 1; i <= N; i++) {
				count += Math.min(mid/i, N);
			}
			
			// count가 많다는 것은 임의의 x(mid)보다 작은 수가 B[k]보다 많다는 뜻
			if(k <= count) end = mid;
			else start = mid + 1;
		}
		System.out.println(start);
	}
}