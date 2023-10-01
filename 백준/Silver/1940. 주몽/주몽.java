import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, count;
	static int[] ingredient, data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 재료의 개수
		N = Integer.parseInt(br.readLine());
		// 갑옷을 만드는데 필요한 수 M
		M = Integer.parseInt(br.readLine());
		ingredient = new int[N];
		data = new int[2];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			ingredient[i] = Integer.parseInt(st.nextToken());
		}
		combination(0, 0);
		System.out.println(count);
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == 2) {
			if((data[0] + data[1]) == M) count++;
			return;
		}
		
		for(int i = start; i < N; i++) {
			data[cnt] = ingredient[i];
			combination(cnt+1, i+1);
		}
	}
}
