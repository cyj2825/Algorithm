import java.io.*;
import java.util.*;

public class Main {
	static int[] students;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		students = new int[30];
		for(int i = 0; i < 28; i++) {
			int x = Integer.parseInt(br.readLine());
			students[x-1] = 1;
		}
		
		for(int i = 0; i < 30; i++) {
			if(students[i] == 0) System.out.println(i+1);
		}
		br.close();
	}
}