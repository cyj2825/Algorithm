import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] data = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data);
		for (int i = 1; i < n; i++) {
			data[i] += data[i-1];
		}
		int answer = 0;
		for(int x : data) {
			answer += x;
		}
		System.out.println(answer);
	}
}