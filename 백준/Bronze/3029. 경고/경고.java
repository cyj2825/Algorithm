import java.io.*;
import java.util.*;

public class Main {
	static int answerH, answerM, answerS;
	static String answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ":");
		int sh = Integer.parseInt(st.nextToken());
		int sm = Integer.parseInt(st.nextToken());
		int ss = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), ":");
		int eh = Integer.parseInt(st.nextToken());
		int em = Integer.parseInt(st.nextToken());
		int es = Integer.parseInt(st.nextToken());
		
		if(sh == eh && sm == em && ss == es) System.out.println("24:00:00");
		else {
			if(sh > eh) {
				answerH = 24 - sh + eh; 
			}
			else {
				answerH = eh - sh;
			}
			
			if(sm > em) {
				answerM = 60 + em- sm;
				answerH--;
			}
			else {
				answerM = em - sm;
			}
			
			if(ss > es) {
				answerS = 60 + es- ss;
				if(1 <= answerM) answerM--;
				else {
					answerH--;
					answerM = 59;
				}
			}
			else {
				answerS = es - ss;
			}
			answer = String.format("%02d:%02d:%02d", answerH, answerM, answerS);
			System.out.println(answer);
		}
	}
}