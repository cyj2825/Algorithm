import java.io.*;
import java.util.*;

public class Main {
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 7:00 부터 19:00까지 전화 요금은 1분에 10원
		// 19:00부터 7:00까지 전화 요금은 1분에 5원
		// HH:MM 전화를 건 시간, DD 통화 시간(분)
		for(int i = 0; i < N; i++) {
			StringTokenizer hmd= new StringTokenizer(br.readLine(), " ");
			StringTokenizer hm = new StringTokenizer(hmd.nextToken(), ":");
			int hh = Integer.parseInt(hm.nextToken());
			int mm = Integer.parseInt(hm.nextToken());
			int dd = Integer.parseInt(hmd.nextToken());
			
			if(7 <= hh && hh <= 17) {
				answer += dd * 10;
				continue;
			}
			else if(19 <= hh && hh <= 5) {
				answer += dd * 5;
				continue;
			}
			
			// 구간이 바뀔 경우 따로 처리
			for(int j = 1; j <= dd; j++) {
				if(7 <= hh && hh <= 18) answer += 10;
				else answer += 5;
				if((mm + j) == 60) {
					hh += 1;
					mm = 0;
				}
			}
		}
		System.out.println(answer);
	}
}