import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String start = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < start.length(); i++) {
			// 문자를 숫자로 변환 (2진수)
			String x = Integer.toBinaryString(start.charAt(i) - '0');
			if(i != 0 && x.length() == 2) x = "0" + x;
			else if(i != 0 && x.length() == 1) x = "00" + x;
			sb.append(x);
		}
		System.out.println(sb);
	}
}