import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n, l;
	static char[][] star;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		// 별의 길이가 2의 n제곱이다.
		l = (int)Math.pow(2, n);
		// 별 찍기 위해 char 배열 생성 
		star = new char[l][l];
		// Arrays.fill()함수를 사용하여 빈칸으로 초기화
		for (int i=0; i<l; i++)
            Arrays.fill(star[i], ' ');
		// 재귀함수에 초기값 대입
		recur(0, 0, l);
		
		StringBuilder sb = new StringBuilder();
		// 출력
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l-i; j++) {
                sb.append(star[i][j]); 
            }
            if(i != l-1) 
            	sb.append("\n");
        }
        System.out.print(sb);
	}
	// 재귀함수
	private static void recur(int x, int y, int length) {
		// 만약 입력값이 0이라서 길이가 1일 경우 '*' 하나만 출력하면 됨
		if (length == 1) {
			star[x][y] = '*';
			return;
		}
		// 숫자가 증가할 때마다 이전 값들을 두 번씩 찍어내면 됨
		int newLength = length/2;
		recur(x, y, newLength);
		recur(x, y + newLength, newLength);
		recur(x + newLength, y, newLength);
	}
}