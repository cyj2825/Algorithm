import java.io.*;
import java.util.*;

// 이진탐색 문제
public class Main {
	static int N, M, data[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N];
		int start = 0;
		int end = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			// 시작 인덱스 저장 : A 배열 중 최댓값
			start = Math.max(start, data[i]);
			// 종료 인덱스 저장 : A 배열의 총합
			end += data[i];
		}
		
		while(start <= end) {
			int mid = (start+end)/2;
			// 현재 사용한 블루레이 수
			int count = 0;
			// 레슨 합
			int sum = 0;
			
			for(int i = 0; i < N; i++) {
				// 현재 구한 A 배열 중 최댓값보다 큰 구역을 발견하면 블루레이 사용
				if(sum + data[i] > mid) {
					count++;
					sum = 0;
				}
				sum = sum + data[i];
			}
			if(sum != 0) count++;
			// 중앙값 크기로 모든 레슨 저장 불가능
			if(count > M) start = mid + 1;
			// 중앙값 크기로 모든 레슨 저장 가능
			else end = mid - 1;
		}
		System.out.println(start);
	}
}