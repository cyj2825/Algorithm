import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static long T, answer;
	static int[] A, B;
	static ArrayList<Integer> AList, BList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Long.parseLong(br.readLine());
		n = Integer.parseInt(br.readLine());
		A = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		m = Integer.parseInt(br.readLine());
		B = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < n; i++) A[i] += A[i-1];
		for(int i = 1; i < m; i++) B[i] += B[i-1];

		int aSize = n * (n+1) / 2;
		int bSize = m * (m+1) / 2;
		long[] aSum = new long[aSize];
		int idx = 0;
		// A 배열에서 나올 수 있는 모든 경우의 합 구하기
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int x = A[j];
				if(i > 0) x -= A[i-1];
				aSum[idx++] = x;
			}
		}

		long[] bSum = new long[bSize];
		idx = 0;
		// B 배열에서 나올 수 있는 모든 경우의 합 구하기
		for (int i = 0; i < m; i++) {
			for (int j = i; j < m; j++) {
				int x = B[j];
				if(i > 0) x -= B[i-1];
				bSum[idx++] = x;
			}
		}
		
		Arrays.sort(aSum);
		Arrays.sort(bSum);
		int start = 0;
		int end = bSize - 1;
		// 투 포인터
		while(start < aSize && end > -1) {
			long aVal = aSum[start], bVal = bSum[end];
			long sum = aVal + bVal;
			if(sum == T) {
				long aCnt = 0, bCnt = 0;
				while(start < aSize && aVal == aSum[start]) {
					start++;
					aCnt++;
				}
			
				while(end > -1 && bVal == bSum[end]) {
					end--;
					bCnt++;
				}
				answer += aCnt * bCnt;
			}
			
			if(sum > T) end--;
			else if(sum < T) start++;
		}
		
		System.out.println(answer);
	}
}