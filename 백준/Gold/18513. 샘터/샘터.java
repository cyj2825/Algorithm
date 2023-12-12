import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[] pos;
	static long answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 샘터 위치만 따로 저장
		pos = new int[N];

		// BFS를 통해 탐색을 진행하기 위해
		Queue<Integer> q = new LinkedList<>();
		// visited 처리해주기 위해
		HashSet<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pos[i] = Integer.parseInt(st.nextToken());
			q.offer(pos[i]);
			set.add(pos[i]);
		}

		int cnt = 1;
		loop: 
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				// 집을 지을 수 있는 가능성이 있는 위치값
				int data = q.poll();
				int left = data - 1;
				int right = data + 1;

				if (!set.contains(left)) {
					q.offer(left);
					set.add(left);
					answer += cnt;
					// 만약 주어진 집 개수만큼 집을 지었다면 while문 종료
					if (--K == 0) break loop;
				}
				if (!set.contains(right)) {
					q.offer(right);
					set.add(right);
					answer += cnt;
					// 만약 주어진 집 개수만큼 집을 지었다면 while문 종료
					if (--K == 0) break loop;
				}
			}
			cnt++;
		}
		System.out.println(answer);
	}
}