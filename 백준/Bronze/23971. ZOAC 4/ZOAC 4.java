import java.io.*;
import java.util.*;

public class Main {
	static int W, H, N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int x = (W-1) / (N+1) + 1;
		int y = (H-1) / (M+1) + 1;
		System.out.println(x * y);
	}
}