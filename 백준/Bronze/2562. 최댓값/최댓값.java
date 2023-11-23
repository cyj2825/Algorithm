import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] data = new int[9];
		
		for(int i = 0 ; i < 9 ; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
 
		int max = 0;
		int index = 0;
		int cnt = 0;
		for(int value : data) {
			cnt++;
			if(value > max) {
				max = value;
				index = cnt;
			}
		}
		System.out.println(max);
		System.out.println(index);
	}
}