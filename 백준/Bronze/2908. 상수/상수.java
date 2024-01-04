import java.io.*;
import java.util.*;
 
public class Main {
	static int A, B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		// StringBuilder는 문자열을 다루는 클래스
		// reverse() 메소드를 통해 문자를 뒤집는다
		A = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		B = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		
		System.out.print(A > B ? A:B);
	}
}