import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
		int cnt = 0;
        int val;
		while(true) {
			val = System.in.read();
			
			if(val == '\n') break;
			
			if(val < 68) cnt += 3;
			else if(val < 71) cnt += 4;
			else if(val < 74) cnt += 5;
			else if(val < 77) cnt += 6;
			else if(val < 80) cnt += 7;
			else if(val < 84) cnt += 8;
			else if(val < 87) cnt += 9;
			else cnt += 10;
		}
		System.out.print(cnt);
	}
}