import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] data;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String a = br.readLine();
			for(int j = 0; j < N; j++) {
				data[i][j] = a.charAt(j) - '0';
			}
		}
		find(0, 0, N);
		System.out.println(sb);
	}
	
	// 분할 정복 함수
	private static void find(int r, int c, int size) {
		int val = data[r][c];
		int count = 0;
		
		for(int i = r; i < r + size; i++) {
			for(int j = c; j < c + size; j++) {
				// 맨 처음값과 비교
				if(val == data[i][j]) {
					count++;
				}
			}
		}
		
		// 만약 val과 모두 같다면 count값은 size*size
		if(count == size*size) {
			sb.append(val);
			return;
		}
		
		int half = size/2;
		// 사분면 분할 여는 괄호
		sb.append('(');
		find(r, c, half);                  // 1
		find(r, c + half, half);           // 2
		find(r + half, c, half);           // 3
		find(r + half, c + half, half);    // 4
		sb.append(')');
	}
}