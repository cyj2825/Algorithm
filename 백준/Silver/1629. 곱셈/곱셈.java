import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 지수 법칙과 모듈러 성질 사용
// 지수 법칙 : 지수를 반으로 나누어 값을 구한 뒤 구한 값을 두 번 곱해준다
public class Main {
	static long A, B, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(pow(A, B));
	}
	
	// A^B % C 값을 구하는 함수 
	public static long pow(long a, long b) {
		// 지수가 1일 경우 A^1이므로 A를 리턴
		if(b == 1) return A % C;
		
		// 지수 법칙을 사용하여 지수의 절반에 해당하는 A^(B/2)값을 구한다
		long val = pow(A, b/2);
		
		// 지수가 홀수라면 A를 한 번 더 곱해준다
		// 모듈러 성질을 이용하여 C 나누기를 각각 해준다
		if(b % 2 == 1) return (val * val % C) * A % C;
		// 지수가 짝수일 경우 그대로 리턴
		return val * val % C;
	}
}
