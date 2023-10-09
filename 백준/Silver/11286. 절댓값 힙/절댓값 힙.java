import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 연산의 개수
		N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// 만일 2차원 배열의 첫 번째 원소가 같다면, 2번째 원소를 기준으로 오름차순 정렬
				if(o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				}
				// 2차원 배열의 첫 번째 원소를 기준으로 오름차순 정렬
				return Integer.compare(o1[0], o2[0]);
			}
		});
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				if(pq.isEmpty()) sb.append(0 + "\n");
				else sb.append(pq.poll()[1] + "\n");
			}
			else pq.offer(new int[] {Math.abs(x), x});
		}
		System.out.println(sb.toString());
		br.close();
	}
}