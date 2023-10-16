import java.io.*;
import java.util.*;

// 음수*음수가 이루어지도록 코드 작성해야 함
public class Main {
	static int N, answer = 0;
	static List<Integer> plus = new ArrayList<>();
	static List<Integer> minus = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x > 0) plus.add(x);
			else minus.add(x);
		}
		Collections.sort(plus, Collections.reverseOrder());
		Collections.sort(minus);
		
		int i = 0;
		while(i < plus.size()) {
			if((i+1) < plus.size() && plus.get(i) != 1&& plus.get(i+1) != 1) {
				// 둘 다 1이 아닐 경우 곱하는 것이 가장 크다
				answer += plus.get(i++) * plus.get(i++);
			}
			// 만약 둘 중에 하나라도 1이거나 i+1가 plus.size()와 같거나 클 경우 그냥 더해준다
			else answer += plus.get(i++);
		}
		
		i = 0;
		while(i < minus.size()) {
			if((i+1) < minus.size()) {
				// i+1가 minus.size()보다 작으면 두 수를 곱한게 가장 크다
				answer += minus.get(i++) * minus.get(i++);
			}
			else answer += minus.get(i++);
		}
		System.out.println(answer);
		br.close();
	}
}