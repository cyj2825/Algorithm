import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data);
		
		int left = 0;
		int right = N-1;
		int num = Integer.MAX_VALUE;
		int first = 0;
		int second = 0;
		int sum = 0;
		int tmp = 0;
		while(left < right) {
			sum = data[left] + data[right];
			tmp = Math.abs(sum);
			if(tmp < num) {
				num = tmp;
				first = data[left];
				second = data[right];
			}
			if(sum > 0) right--;
			else left++;
		}
		System.out.println(first + " " + second);
	}
}