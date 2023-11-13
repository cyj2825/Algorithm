import java.io.*;

public class Main {
	static String s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = null;
		while(true) {
			s = br.readLine();
			
			if(s.equals("END")) break;
			sb = new StringBuilder();
			for(int i = s.length()-1; 0 <= i; i--) {
				sb.append(s.charAt(i));
			}
			System.out.println(sb);
		}
	}
}