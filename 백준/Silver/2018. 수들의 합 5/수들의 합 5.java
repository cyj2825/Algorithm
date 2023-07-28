import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 정수 n 받기
		int n = Integer.parseInt(st.nextToken());
		int s = 1;
		int e = 1;
		int sum = 1;
		int answer = 0;
				
		while(s <= e) {
			if(sum == n) {
				answer += 1;
			}
			if(sum >= n) {
				sum -= s++;
			}
			else if (sum < n) {
				e++;
				sum += e;
			}
		}
		System.out.println(answer);
	}
}
