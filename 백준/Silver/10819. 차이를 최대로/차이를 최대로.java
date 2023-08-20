import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, maxVal;
	static int[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		maxVal = 0;
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data);
		do {
			int val = 0;
			for(int i = 0; i < N-1; i++) {
				val += Math.abs(data[i] - data[i+1]);
			}
			maxVal = Math.max(val, maxVal);
		}while(np(data));
		System.out.println(maxVal);
	}
	
	private static boolean np(int[] data) {
		int n = data.length;
		int i = n - 1;
		while(i > 0 && data[i-1] >= data[i]) --i;
		if(i == 0) return false;
		
		int j = n - 1;
		while(data[i-1] >= data[j]) --j;
		swap(data, i-1, j);
		
		int k = n - 1;
		while(i < k) swap(data, i++, k--);
		return true;
	}

	private static void swap(int[] data, int a, int b) {
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
}