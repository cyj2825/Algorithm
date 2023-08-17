import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 에라토스테네스의 체 원리 사용
public class Main {
	static int[] data;
	static List<Integer> answer = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		data = new int[n+1];
		// 소수가 아니라면 0
		// 0과 1은 소수가 아니므로 0
		data[0] = data[1] = 0;
		// 자신의 값을 넣어 초기화해 줌 
		for(int i = 2; i <= n; i++) data[i] = i;
		
		for(int i = 2; i < n; i++) {
			// 소수가 아니라면 continue
			if(data[i] == 0) continue;
			// 소수의 배수는 소수를 약수로 가지므로 0값 부여
			for(int j = 2*i; j <= n; j+=i) data[j] = 0;
		}
		
		for(int i = m; i < data.length; i++) {
			if(data[i] != 0) answer.add(i);
		}
		StringBuilder sb = new StringBuilder();
		for(int x: answer) {
			sb.append(x + "\n");
		}
		System.out.println(sb);
	}
}