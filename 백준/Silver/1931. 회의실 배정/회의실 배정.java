import java.io.*;
import java.util.*;

public class Main {
	static int N, answer;
	static int[][] time;
			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		time = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 끝나는 시간을 기준으로 정렬하기 위해 compare 재정의
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// 종료시간이 같을 경우 시작 시간이 빠른 순으로 정렬
				if(o1[1] == o2[1]) return o1[0] - o2[0];
				
				return o1[1] - o2[1];
			}
		});
		
		int pre_end_time = 0;
		
		for(int i = 0; i < N; i++) {
			// 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
			if(pre_end_time <= time[i][0]) {
				pre_end_time = time[i][1];
				answer++;
			}
		}
		System.out.println(answer);
	}
}