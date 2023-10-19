import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
		// 최소값을 담을 변수 초기화
		int answer = Integer.MAX_VALUE;
		// 뺄셈을 기준으로 분리한 문자열을 더이상 토큰이 존재하지 않을 때까지 while문 반복
		while(sub.hasMoreTokens()) {
			int tmp = 0;
			// 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더함
			StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");
			
			// 덧셈으로 나뉜 토큰들을 모두 더함
			while(add.hasMoreTokens()) {
				tmp += Integer.parseInt(add.nextToken());
			}
			
			// 첫 번째 토큰일 경우 양수이므로 tmp를 더해준다
			if (answer == Integer.MAX_VALUE) answer = tmp;
			else answer -= tmp;
		}
		System.out.println(answer);
		br.close();
	}
}