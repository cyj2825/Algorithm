import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] data, key;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		data = new char[C];
		key = new char[L];
		
		String s = br.readLine();
		int a = 0;
		for (int i = 0; i < C; i++) {
			data[i] = s.charAt(a);
			a += 2;
		}
		Arrays.sort(data);
		combination(0, 0);
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == L) {
			// 모음 개수
			int vCount = 0;
			for(char x : key) {
				if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
					vCount++;
				}
			}
			if(1 <= vCount && 2 <= (L-vCount)){
				StringBuilder sb = new StringBuilder();
				for(char x : key) {
					sb.append(x);
				}
				System.out.println(sb);
			}
			return;
		}
		
		for(int i = start; i < C; i++) {
			key[cnt] = data[i];
			combination(cnt+1, i+1);
		}
	}
}