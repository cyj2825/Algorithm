import java.io.*;
import java.util.*;

// 비트 마스킹 사용
public class Main {
	static int N, M, answer;
	static int[] words;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		words = new int[N];
		// 알파벳마다 기억하고 있는지 상태를 저장하기 위해 비트 마스킹 사용
		// 초기에 모든 알파벳을 알고 있기에 26자리의 비트가 모두 1인 상태로 초기화
		int alphabet = (1 << 27) -1;
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(char c : s.toCharArray()) {
				// or 연산을 사용하여 해당 알파벳 비트를 1로 변경
				words[i] |= 1 << (c - 'a');
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int o = Integer.parseInt(st.nextToken());
			int x = st.nextToken().charAt(0) - 'a';
			if(o == 1) {
				if(x == 0 || x == 4 || x == 8 || x == 14 || x == 20) continue;
				// 해당 알바벳 0으로 변경
				alphabet &= ~(1 << x);
			}
			else if(o == 2) {
				alphabet |= (1 << x);
			}
			
			answer = 0;
			for (int word : words) {
				// & 연산을 통해 word에 해당하는 모든 비트가 켜져있다면 word와 같아지게 된다
				if((alphabet & word) >= word) answer++;
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}
}