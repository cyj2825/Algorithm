import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String name[] = new String[N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			name[i] = str.substring(0,1)+str.substring(str.length()-1,str.length());	
		}
		br.close();
		for(int i=0;i<N;i++) {
			System.out.println(name[i]);	
		}	
	}
}