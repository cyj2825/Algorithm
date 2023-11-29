import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] A, B, C, D, AB, CD;
	static long answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N], B = new int[N], C = new int[N], D = new int[N];
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		AB = new int[N*N];
		CD = new int[N*N];
		int index = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				AB[index] = A[i] + B[j];
				CD[index] = C[i] + D[j];
				index++;
			}
		}
		
		Arrays.sort(AB);
		Arrays.sort(CD);
		
		int left = 0;
		int right = N*N-1;
		while(left < N*N && right >= 0) {
			if (AB[left] + CD[right] < 0) left++;
			else if (AB[left] + CD[right] > 0) right--;
			else {
				long leftCnt = 1, rightCnt = 1;
				while (left + 1 < N*N && (AB[left] == AB[left+1])) {
					leftCnt++;
					left++;
				}
				while (right > 0 && (CD[right] == CD[right-1])) {
					rightCnt++;
					right--;
				}
				answer += leftCnt * rightCnt;
				left++;
			}
		}
		System.out.println(answer);
	}
}