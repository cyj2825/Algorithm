import java.io.*;

public class Main {
	static int sumNum; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			sumNum += i;
		}
		
		System.out.println(sumNum);
	}
}