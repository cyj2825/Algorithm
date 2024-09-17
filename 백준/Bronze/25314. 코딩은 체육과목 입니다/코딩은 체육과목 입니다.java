import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int num = N / 4;
		String str = "";
		for (int i = 0; i < num; i++) {
			str += "long ";
		}
		str += "int";
		System.out.println(str);
	}
}
