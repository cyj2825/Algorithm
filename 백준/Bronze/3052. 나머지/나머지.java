import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		boolean b;
		int cnt = 0;

		for(int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(br.readLine()) % 42;
		
		for(int i = 0; i < 10; i++) {
			b = false;
			for(int k = i+1; k < arr.length; k++) {
				if(arr[i] == arr[k]) {
					b = true;
					break;
				}
			}
			if(b == false) cnt++;
		}
		System.out.println(cnt);
	}
}