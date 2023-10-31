import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(order == 1) {
				// XOR 연산 사용 -> 0^1일 경우는 1, 1^1일 경우는 0을 리턴
				data[a-1] = b;
			}
			else if(order == 2) {
				for(int j = a-1; j <= b-1; j++) {
					data[j] ^= 1;
				}
			}
			else if(order == 3) {
				for(int j = a-1; j <= b-1; j++) {
					data[j] = 0;
				}
			}
			else if(order == 4) {
				for(int j = a-1; j <= b-1; j++) {
					data[j] = 1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i : data) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}
}