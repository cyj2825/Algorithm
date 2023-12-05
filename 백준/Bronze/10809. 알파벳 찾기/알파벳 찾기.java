import java.io.*;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[26];
		for(int i = 0; i < arr.length; i++) arr[i] = -1;
 
		String S = br.readLine();
 
		for(int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
    
			if(arr[ch - 'a'] == -1) {
				arr[ch - 'a'] = i;
			}
		}
        
        StringBuilder sb = new StringBuilder();
		for(int val : arr) {
			sb.append(val + " ");
		}
        System.out.println(sb);
	}
}