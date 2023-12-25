import java.io.*;
import java.util.*;

public class Main {
	static int N, answer = 0;
	static int[] A, B, data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Integer[] BArray = Arrays.stream(B).boxed().toArray(Integer[]::new);
		Arrays.sort(BArray, Collections.reverseOrder());
		
		for(int i = 0; i < N; i++) {
			answer += A[i] * BArray[i];
		}
		System.out.println(answer);
	}
}