import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, maxRead;
	static boolean[] alpha;    // false이면 안 가르침, true이면 가르침
	static String[] words;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		alpha = new boolean[26];
		words = new String[N];
		maxRead = 0;
		
		// K가 5보다 작을 경우 'anta', 'tica'도 읽을 수 없으므로 0 출력 후 종료
		if (K < 5) {
			System.out.println(0);
			return;
		}
		
		// 'anta', 'tica'에 속하는 알파벳 값은 미리 true로 변경
		alpha['a' - 97] = true;
		alpha['c' - 97] = true;
		alpha['i' - 97] = true;
		alpha['n' - 97] = true;
		alpha['t' - 97] = true;
		
		// 입력받은 단어들을 words 배열에 넣기
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		
		combination(0, 0);
		System.out.println(maxRead);
	}
	
	private static void combination (int cnt, int start) {
		if(cnt == K-5) {
			maxRead = Math.max(maxRead, possibleRead());
			return;
		}
		for(int i = start; i < 26; i++) {
			// 이미 배운 알파벳이라면 다시 배울 필요없음
			if(alpha[i]) continue;
			alpha[i] = true;
			combination(cnt+1, i+1);
			alpha[i] = false;
		}
	}
	private static int possibleRead() {
		int read = 0;
		for(String x : words) {
			boolean readB = true;
			for(int i = 0; i < x.length(); i++) {
				if(!alpha[x.charAt(i) - 97]) {
					readB = false;
					break;
				}
			}
			if (readB) read += 1;
		}
		return read;
	}
}