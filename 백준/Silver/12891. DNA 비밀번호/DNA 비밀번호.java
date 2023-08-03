import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int myDNA[];
	static int checkDNA[];
	static int check, answer;
	static char[] DNA;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		myDNA = new int[4];
		checkDNA = new int[4];
		DNA = new char[s];
		answer = 0;
		check = 0;
		
		// string으로 주어지는 값을 char값으로 잘라서 넣기
		DNA = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		// 만족해야 하는 조건에 대한 배열 값 넣기
		for(int i = 0; i < 4; i++) {
			checkDNA[i] = Integer.parseInt(st.nextToken());
			if(checkDNA[i] == 0) {
                check++; // 0이라면 이미 조건을 만족
            }
		}
		// 부분 문자열 받기, 슬라이딩 윈도우 초기 상태
		for(int i = 0; i < p; i++) {
			Add(DNA[i]);
		}
		if(check == 4) answer ++;
		
		 // 슬라이딩 윈도우 (1칸 이동한 상태)
        for(int i=p; i<s; i++) { // i는 슬라이딩 윈도우 가장 끝 부분
            int j = i-p; // j는 슬라이딩 윈도우 가장 앞부분
            Add(DNA[i]);
            Remove(DNA[j]);
            if(check == 4) answer++;
        }
        System.out.println(answer);
        br.close();
	}
	 private static void Remove(char c) {
		 switch(c) {
         case 'A' :
             if(myDNA[0] == checkDNA[0]) check--;
             myDNA[0]--;
             break;
         case 'C' :
             if(myDNA[1] == checkDNA[1]) check--;
             myDNA[1]--;
             break;
         case 'G' :
             if(myDNA[2] == checkDNA[2]) check--;
             myDNA[2]--;
             break;
         case 'T' :
             if(myDNA[3] == checkDNA[3]) check--;
             myDNA[3]--;
             break;
		 }

	 }
	 private static void Add(char c) {
		 switch(c) {
         case 'A' :
        	 myDNA[0]++;
             if(myDNA[0] == checkDNA[0]) check++;
             break;
         case 'C' :
        	 myDNA[1]++;
             if(myDNA[1] == checkDNA[1]) check++;
             break;
         case 'G' :
        	 myDNA[2]++;
             if(myDNA[2] == checkDNA[2]) check++;
             break;
         case 'T' :
        	 myDNA[3]++;
             if(myDNA[3] == checkDNA[3]) check++;
             break;
		 }
	 }
	        
}
