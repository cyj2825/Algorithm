import java.io.*;
import java.util.*;

public class Main {
	static int N, B;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		ArrayList<Character> list = new ArrayList<>();
		while(N > 0) {
			// N % B가 9이하라면
			if(N % B < 10) list.add((char) (N % B + '0'));
			else list.add((char) (N % B - 10 + 'A'));
			N /= B;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = list.size()-1; 0 <= i; i--) sb.append(list.get(i));
		System.out.println(sb);
	}
}